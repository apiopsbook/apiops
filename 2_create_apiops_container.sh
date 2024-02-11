#!/bin/bash

docker container create -i -t --name apiops-book  --hostname apiops-host -v $(pwd):/book-source  ikenna4u/apiopsbook:v1.0
docker ps -a