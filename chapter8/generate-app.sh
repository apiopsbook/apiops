#!/bin/bash

openapi-generator-cli generate --input-spec product-catalog.oas.yaml --generator-name spring --skip-validate-spec --additional-properties=library=spring-boot,apiPackage=com.acmepetsupplies.controller,modelPackage=com.acmepetsupplies.model,configPackage=com.acmepetsupplies.configuration,basePackage=com.acmepetsupplies,useTags=true