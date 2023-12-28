#!/usr/bin/env node

const {faker} = require('@faker-js/faker');
const axios = require('axios').default;
const {v4: uuidv4} = require('uuid');
const fs = require('fs');
const moesifApiKey = process.argv[3];
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


function moesifUserSignUpAction(user) {
    return {
        method: 'post',
        url: `https://api.moesif.net/v1/actions`,
        headers: {
            'X-Moesif-Application-Id': moesifApiKey,
        },
        data: {
            action_name: "Created API key",
            user_id: user.userId,
            request: {
                // time: "2023-12-16T08:53:04Z",
                uri: "http://localhost/devportal",
            }
        }
    }
}

function moesifCreateMoesifCompany(company) {
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
                org_name: company.metadata.orgName
            }
        }
    }
}

function moesifCreateUser(user) {
    return {
        method: 'post',
        url: `https://api.moesif.net/v1/users`,
        headers: {
            'X-Moesif-Application-Id': moesifApiKey,
        },
        data: {
            user_id: user.userId,
            company_id: user.companyId,
            metadata: {
                email: user.metadata.email,
                first_name: user.metadata.firstName,
                last_name: user.metadata.lastName,
                title: user.metadata.title,
            }

        }
    }
}


function createUserProfiles(count) {
    let profiles = [];
    for (let i = 0; i < count; i++) {
        const company = {
            companyId: uuidv4(),
            companyDomain: faker.internet.domainName(),
            metadata: {
                orgName: faker.company.name()
            }
        }
        const user = {
            username: faker.internet.userName(),
            userId: null,
            apiKey: null,
            company: company.companyId,
            metadata: {
                email: faker.internet.email(),
                firstName: faker.person.firstName(),
                lastName: faker.person.lastName(),
                title: faker.person.jobTitle(),
                address: {
                    street: faker.location.streetAddress(),
                    city: faker.location.city(),
                    state: faker.location.state(),
                    zip: faker.location.zipCode(),
                    country: faker.location.country()
                }
            }
        }
        profiles.push({user: user, company: company});
    }
    return profiles;
}

function simulateSignUp(userProfiles) {
    const singUps = userProfiles.map((profiles) => {
        return axios(moesifCreateMoesifCompany(profiles.company)).then(() => {
            return axios(kongCreateConsumer(profiles.user.username));
        }).then((response) => {
            profiles.user.userId = response.data.id
            return axios(kongCreateAPIkey(profiles.user.userId))
        }).then((response) => {
            profiles.user.apiKey = response.data.key
            moesifCreateUser(profiles.user);
        }).then(() => {
            moesifUserSignUpAction(profiles.user);
        })
            .then((response) => {
                return {
                    username: profiles.user.username,
                    userId: profiles.user.userId,
                    sandboxApiKey: profiles.user.apiKey,
                    companyId: profiles.company.companyId,
                    company: profiles.company.metadata.orgName
                };
            });
    });

    return Promise.all(singUps)
}


////Main
const numberOfUsersToCreate = process.argv[2];
console.log(`Number of users to create: ${numberOfUsersToCreate}`)
let profiles = createUserProfiles(numberOfUsersToCreate);
simulateSignUp(profiles).then((signUp) => {
    fs.writeFileSync("signups.json", JSON.stringify(signUp, null, 2));
    console.log("The following sign-ups were created and written to signups.json");
    console.log(JSON.stringify(signUp, null, 2));
})





