#!/bin/bash

st run  \
  --checks all \
  --contrib-openapi-formats-uuid \
  --cassette-path cassette.yaml \
  --data-generation-method all   \
  --base-url http://localhost:8000 \
  --header "X-API-Key: my_secret_api_key" \
  --header "Host: api.acme-pet-supplies.com"  product-catalog-v1-0.oas.yaml
