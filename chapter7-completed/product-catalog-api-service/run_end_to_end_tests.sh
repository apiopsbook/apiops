#!/usr/bin/env bash
./start_api_service.sh
 mvn test -Dtest=EndToEndSchemaTest
./stop_api_service.sh
