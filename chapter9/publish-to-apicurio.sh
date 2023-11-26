#!/usr/bin/env bash

curl -v -X POST 'http://localhost:9090/apis/registry/v2/groups/acmeapis/artifacts?ifExists=UPDATE'    \
--header 'Content-Type: application/x-yaml'     \
--header 'X-Registry-ArtifactId: productsapi'    \
--header 'X-Registry-ArtifactType: OPENAPI'     \
--data-binary "@chapter8/apis/product-catalog.oas.yaml"    \
--output created-artifact.json   \
--fail-with-body
