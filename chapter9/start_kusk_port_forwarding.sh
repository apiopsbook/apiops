#!/usr/bin/env bash

kubectl port-forward svc/kusk-gateway-envoy-fleet -n kusk-system 8080:80