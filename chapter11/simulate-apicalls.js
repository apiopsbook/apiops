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



function getRandom() {
    const runs = [2, 5, 6];
    const random = Math.floor(Math.random() * runs.length);
    return runs[random];
}

function runRequests(user, numberOfRequests) {
    return axios(productsApiCalls(user.sandboxApiKey)).then((response) => {
        console.log(response.status);
        return axios(categoriesApiCall(user.sandboxApiKey));
    }).then((response) => {
        console.log(response.status);
        return axios(reviewsApiCall(user.sandboxApiKey));
    }).then((response) => {
        console.log(response.status);
        return user.sandboxApiKey
    }).catch((error) => {
        console.log(error);
    });

}


//Main
const data = fs.readFileSync("signups.json", "utf8");
const signups = JSON.parse(data);
for (user of signups) {
    let runCount = getRandom();
    console.log(`${user.username} running ${runCount}`);
    runRequests(user, runCount);
}


