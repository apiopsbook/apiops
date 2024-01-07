#!/usr/bin/env node

const {faker} = require('@faker-js/faker');
const axios = require('axios').default;
const {v4: uuidv4} = require('uuid');
const fs = require('fs');
const {program} = require('commander');
const dayjs = require('dayjs')

function kongCreateConsumer(userName) {
    return {
        method: 'post',
        url: 'http://127.0.0.1:8001/consumers',
        headers: {
            'Content-Type': 'application/json'
        },
        data: {
            username: userName
        }
    }
}

function kongCreateAPIkey(userId) {
    return {
        method: 'post',
        url: `http://127.0.0.1:8001/consumers/${userId}/key-auth`,
    }
}


function moesifUserSignUpAction(user, moesifApiKey) {

    return {
        method: 'post',
        url: `https://api.moesif.net/v1/actions`,
        headers: {
            'X-Moesif-Application-Id': moesifApiKey,
        },
        data: {
            action_name: "Sign-Up",
            user_id: user.userId,
            request: {
                uri: "http://localhost/devportal",
            }
        }
    }
}

function moesifCreateMoesifCompany(company, moesifApiKey) {
    return {
        method: 'post',
        url: `https://api.moesif.net/v1/companies`,
        headers: {
            'X-Moesif-Application-Id': moesifApiKey,
        },
        data: {
            company_id: company.companyId,
            company_domain: company.companyDomain,
            metadata: {
                org_name: company.metadata.orgName,
                cohort: company.metadata.cohort
            }
        }
    }
}

function moesifCreateUser(user, moesifApiKey) {
    let userRequest = {
        method: 'post',
        url: `https://api.moesif.net/v1/users`,
        headers: {
            'X-Moesif-Application-Id': moesifApiKey,
        },
        data: {
            user_id: user.userId,
            company_id: user.companyId,
            modified_time: user.signUpDate,
            metadata: {
                email: user.metadata.email,
                first_name: user.metadata.firstName,
                last_name: user.metadata.lastName,
                title: user.metadata.title,
                cohort: user.metadata.cohort
            }

        }
    };
    return userRequest
}


function createUserProfiles(count, cohort) {
    let profiles = [];


    for (let i = 0; i < count; i++) {
        const company = {
            companyId: uuidv4(),
            companyDomain: faker.internet.domainName(),
            metadata: {
                orgName: faker.company.name(),
                cohort: cohort
            }
        }
        let firstName = faker.person.firstName();
        let lastName = faker.person.lastName ();
        const user = {
            username: faker.internet.userName({firstName: firstName, lastName: lastName}),
            userId: null,
            apiKey: null,
            companyId: company.companyId,
            signUpDate: getSignUpDate(),
            metadata: {
                email: faker.internet.email({firstName: firstName, lastName: lastName}),
                firstName: firstName,
                lastName: lastName,
                title: faker.person.jobTitle(),
                address: {
                    street: faker.location.streetAddress(),
                    city: faker.location.city(),
                    state: faker.location.state(),
                    zip: faker.location.zipCode(),
                    country: faker.location.country()
                },
                cohort: cohort
            }
        }
        profiles.push({user: user, company: company});
    }

    return profiles;
}

function simulateSignUp(userProfiles, moesifApiKey) {
    const singUps = userProfiles.map((profiles) => {
        return axios(moesifCreateMoesifCompany(profiles.company, moesifApiKey)).then((response) => {
            console.log(`Created company ${profiles.company.companyId} in Moesif. Moesif response: ${response.status}`);
            return axios(kongCreateConsumer(profiles.user.username));
        }).then((response) => {
            profiles.user.userId = response.data.id
            return axios(kongCreateAPIkey(profiles.user.userId))
        }).then((response) => {
            profiles.user.apiKey = response.data.key
            return axios(moesifCreateUser(profiles.user, moesifApiKey));
        }).then((response) => {
            console.log(`Created user ${profiles.user.userId} in Moesif. Moesif response: ${response.status}`);
            return axios(moesifUserSignUpAction(profiles.user, moesifApiKey));
        })
            .then((response) => {
                console.log(`Created signup-action for user ${profiles.user.userId} in Moesif. Moesif response: ${response.status}`);
                return {
                    email: profiles.user.metadata.email,
                    username: profiles.user.username,
                    userId: profiles.user.userId,
                    apiKey: profiles.user.apiKey,
                    signUpDate: profiles.user.signUpDate,
                    companyId: profiles.company.companyId,
                    company: profiles.company.metadata.orgName
                };
            })
    })

    return Promise.all(singUps)
}

function getSignUpDate(){
    // let minsAgo = faker.helpers.rangeToNumber({ min: 1, max: 80 })
    // let daysAgo = faker.helpers.arrayElement([0, 0, 0, 1, 1, 2, 3, 4, 5, 6])
    // let signUpDate = dayjs().subtract(daysAgo, 'days').subtract(minsAgo, 'minutes').format('YYYY-MM-DDTHH:mm:ss[Z]')
    let signUpDate = dayjs().format('YYYY-MM-DDTHH:mm:ss[Z]')
    return signUpDate;
}


//Main
program
    .requiredOption('-n, --numberOfUsers <numberOfUsers>', 'Number of users to create')
    .requiredOption('-m, --moesifApiKey <moesifApiKey>', 'Moesif API key')
    .requiredOption('-c, --cohort <cohort>', 'Cohort name');
program.addHelpText('after', `

Example call:
  $ ./simulate-signups.js -n 3 -c cohort1 -m $MOESIF_API_KEY`);
program.showHelpAfterError();
program.parse();
const options = program.opts();
const numberOfUsersToCreate = options.numberOfUsers;
moesifApiKey = options.moesifApiKey;
let cohort = options.cohort;
console.log(`Number of users to create: ${numberOfUsersToCreate}`)
let profiles = createUserProfiles(numberOfUsersToCreate, cohort);
simulateSignUp(profiles, moesifApiKey).then((signUp) => {
    let outputFileName = `${cohort}.json`;
    fs.writeFileSync(outputFileName, JSON.stringify(signUp, null, 2));
    console.log(`The following sign-ups were created and written to ${outputFileName}`);
    console.log(JSON.stringify(signUp, null, 2));
})





