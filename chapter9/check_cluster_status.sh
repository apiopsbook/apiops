#!/usr/bin/env bash
set -x
kubectl get pods
kubectl get pods -o=jsonpath='{.items[0].metadata.name}'
POD_NAME=$(kubectl get pods -o=jsonpath='{.items[0].metadata.name}')
kubectl wait --for=condition=Ready pod/$POD_NAME --timeout=60s
kubectl logs $POD_NAME --tail=20