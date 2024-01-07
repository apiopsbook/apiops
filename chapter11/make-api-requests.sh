#!/bin/bash

API_KEY=X9HD6fdKVskGD04NyNEUSxX4ncdwRxPC
curl -v -X GET --url http://localhost:80/v1/catalog/products -H "x-api-key: $API_KEY"
curl -v -X GET --url http://localhost:80/v1/catalog/categories -H "x-api-key: $API_KEY"
curl -v -X GET --url http://localhost:80/v1/catalog/products/c090f93a-7a04-4d92-97af-f46f6fca4341/reviews -H "x-api-key: $API_KEY"

# make requests to server