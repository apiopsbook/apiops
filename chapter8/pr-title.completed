#!/usr/bin/env bash

pr_title=$1
pattern="DEV-[0-9]{4}"

if [[ ! $pr_title =~ $pattern ]]; then
    echo "PR title: $pr_title"
    echo "Error: pull request title does not contain a valid Jira issue reference in the format DEV-XXXX."
    echo "Please include a Jira issue reference in the title of your PR."
    exit 1
fi