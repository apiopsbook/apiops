#!/usr/bin/env node

const axios = require('axios').default;
const fs = require('fs');
const {program} = require("commander");


function deleteUserRequest(userId, moesifMgtApiKey) {
    return {
        method: 'delete',
        url: `https://api.moesif.com/v1/search/~/users/${userId}`,
        params: {
            delete_events: true
        },
        headers: {
            'Authorization': moesifMgtApiKey,
        }
    }
}


function deleteCompanyRequest(companyId, moesifMgtApiKey) {
    return {
        method: 'delete',
        url: `https://api.moesif.com/v1/search/~/companies/${companyId}`,
        params: {
            delete_events: true
        },
        headers: {
            'Authorization': moesifMgtApiKey,
        }
    }
}

function deleteUser(user, moesifMgtApiKey) {
    return axios(deleteUserRequest(user.userId, moesifMgtApiKey))
        .then((response) => {
            console.log(`Deletion of user ${user.username} from Moesif completed with status ${response.status}`);
            return axios(deleteCompanyRequest(user.companyId, moesifMgtApiKey));
        }).then((response) => {
            console.log(`Deletion of company ${user.companyId} from Moesif completed with status ${response.status}`);
        }).catch((error) => {
            console.log(error.response.data);
        });
}


//Main
program
    .requiredOption('-c, --cohortFile <cohortFileName>', 'Cohort file name')
    .requiredOption('-m, --moesifMgtApiKey <moesifMgtApiKey>', 'Moesif Management API key');

program.addHelpText('after', `

Example call:
  $ ./delete-cohort.js -c cohort1.json -m $MOESIF_MGT_API_KEY`);

program.showHelpAfterError();

program.parse();
const options = program.opts();

let cohortFileName = options.cohortFile;
let moesifMgtApiKey = options.moesifMgtApiKey;


const data = fs.readFileSync(cohortFileName, "utf8");
const users = JSON.parse(data);
for (user of users) {
    deleteUser(user, moesifMgtApiKey);
}



