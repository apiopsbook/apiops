#!/usr/bin/env node

const axios = require('axios').default;
const fs = require('fs');
const {v4: uuidv4} = require('uuid');
const { Command, Option } = require('commander');
const program = new Command();
const dayjs = require("dayjs");


function productsApiCalls(productCatalogApiKey, basePath) {
    return {
        method: 'get',
        url: `http://localhost:80/${basePath}/v1/catalog/products`,
        headers: {
            'x-api-key': productCatalogApiKey,
        }
    }
}

function categoriesApiCall(productCatalogApiKey, basePath) {
    return {
        method: 'get',
        url: `http://localhost:80/${basePath}/v1/catalog/categories`,
        headers: {
            'x-api-key': productCatalogApiKey,
        }
    }
}

function reviewsApiCall(productCatalogApiKey, basePath) {
    return {
        method: 'get',
        url: `http://localhost:80/${basePath}/v1/catalog/products/${uuidv4()}/reviews `,
        headers: {
            'x-api-key': productCatalogApiKey,
        }
    }
}


function getRunCount() {
    const runs = [2, 5, 6];
    const random = Math.floor(Math.random() * runs.length);
    return runs[random];
}

function runRequests(user, runCount, basePath) {
    for (let i = 0; i < runCount; i++) {
        let productsRequest = productsApiCalls(user.apiKey, basePath);
        let categoriesRequest = categoriesApiCall(user.apiKey, basePath);
        let reviewsRequest = reviewsApiCall(user.apiKey, basePath);
        axios(productsRequest).then((response) => {
            console.log(`Request to ${productsRequest.url} for ${user.username} completed with status ${response.status}`);
            return axios(categoriesRequest);
        }).then((response) => {
            console.log(`Request to ${categoriesRequest.url} for ${user.username} completed with status ${response.status}`);
            return axios(reviewsRequest);
        }).then((response) => {
            console.log(`Request to ${reviewsRequest.url} for ${user.username} completed with status ${response.status}`);
            return user.apiKey
        }).catch((error) => {
            console.log(error);
        });
    }
}

function isNumber(str) {
    if (typeof str != "string") return false
    return !isNaN(str) && !isNaN(parseFloat(str))
}

//Main

program
    .requiredOption('-c, --cohort <cohort>', 'Cohort name')
    .requiredOption('-w, --waitMinutes <waitMinutes>', 'Wait time in minutes, as an integer')
    .addOption(new Option('-e, --environment <environment>', 'Environment').choices(['sandbox', 'production']).makeOptionMandatory(true));


program.addHelpText('after', `

Example call:
  $ ./simulate-apicalls.js --waitMinutes 5 --cohort cohort1 --environment sandbox`);

program.showHelpAfterError();

program.parse();
const options = program.opts();

let cohort = options.cohort;
let waitMinutes = options.waitMinutes;
let waitMillis = 0;
let basePath = "";
if (options.environment === "sandbox") {
    basePath = "sandbox";
} else if (options.environment === "production") {
    basePath = "api";
} else {
    throw new Error("Environment must be sandbox or production");
}

if (isNumber(waitMinutes)) {
    waitMinutes = parseFloat(waitMinutes);
    waitMillis = waitMinutes * 60 * 1000;
} else {
    throw new Error("Wait time must be a number");
}
console.log(`${dayjs()}. Waiting for ${waitMinutes} minutes...`);
new Promise(resolve => setTimeout(resolve, waitMillis)).then(() => {
    console.log(`${dayjs()}. Running...`);
    const data = fs.readFileSync(`${cohort}.json`, "utf8");
    const signups = JSON.parse(data);
    for (user of signups) {
        let runCount = getRunCount();
        console.log(`${user.username} running ${runCount}`);
        runRequests(user, runCount, basePath);
    }
});


