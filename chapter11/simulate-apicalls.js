#!/usr/bin/env node

const axios = require('axios').default;
const fs = require('fs');
const {v4: uuidv4} = require('uuid');


function productsApiCalls(productCatalogApiKey) {
    return {
        method: 'get',
        url: `http://localhost:80/sandbox/v1/catalog/products`,
        headers: {
            'x-api-key': productCatalogApiKey,
        }
    }
}

function categoriesApiCall(productCatalogApiKey) {
    return {
        method: 'get',
        url: `http://localhost:80/sandbox/v1/catalog/categories`,
        headers: {
            'x-api-key': productCatalogApiKey,
        }
    }
}

function reviewsApiCall(productCatalogApiKey) {
    return {
        method: 'get',
        url: `http://localhost:80/sandbox/v1/catalog/products/${uuidv4()}/reviews `,
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

function runRequests(user, runCount) {
    for (let i = 0; i < runCount; i++) {
        let productsRequest = productsApiCalls(user.sandboxApiKey);
        let categoriesRequest = categoriesApiCall(user.sandboxApiKey);
        let reviewsRequest = reviewsApiCall(user.sandboxApiKey);
        axios(productsRequest).then((response) => {
            console.log(`Request to ${productsRequest.url} for ${user.username} completed with status ${response.status}`);
            return axios(categoriesRequest);
        }).then((response) => {
            console.log(`Request to ${categoriesRequest.url} for ${user.username} completed with status ${response.status}`);
            return axios(reviewsRequest);
        }).then((response) => {
            console.log(`Request to ${reviewsRequest.url} for ${user.username} completed with status ${response.status}`);
            return user.sandboxApiKey
        }).catch((error) => {
            console.log(error);
        });
    }
}


//Main
const data = fs.readFileSync("signups.json", "utf8");
const signups = JSON.parse(data);
for (user of signups) {
    let runCount = getRunCount();
    console.log(`${user.username} running ${runCount}`);
    runRequests(user, runCount);
}


