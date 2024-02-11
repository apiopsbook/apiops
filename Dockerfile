FROM ubuntu:22.04
RUN apt-get update
RUN apt-get upgrade -y

RUN apt-get install -y curl

# Install Go
RUN curl -OL https://golang.org/dl/go1.22.0.linux-amd64.tar.gz \
    && tar -C /usr/local -xzf go1.22.0.linux-amd64.tar.gz \
    && rm go1.22.0.linux-amd64.tar.gz

ENV PATH="/usr/local/go/bin:${PATH}"

ARG OASDIFF_VERSION=1.10.8
ARG SPECTRAL_VERSION=6.11.0
ARG REDOCLY_VERSION=1.8.2
ARG PRISM_VERSION=5.5.4
ARG PORTMAN_VERSION=1.22.0
ARG SCHEMATHESIS_VERSION=3.25.0
ARG OPENAPI_GENERATOR_VERSION=2.9.0
ARG YQ_VERSION=4.2.0

# Install Oasdiff
RUN mkdir -p /tmp/oasdiff && \
    curl -fqL -o oasdiff.zip https://github.com/Tufin/oasdiff/releases/download/v${OASDIFF_VERSION}/oasdiff_${OASDIFF_VERSION}_linux_amd64.tar.gz && \
    tar xf oasdiff.zip --directory /tmp/oasdiff && \
    mv /tmp/oasdiff/oasdiff /usr/local/bin/oasdiff && \
    chmod +x /usr/local/bin/oasdiff && \
    rm -rf /tmp/oasdiff oasdiff.zip

# Install Node.js
RUN curl -sL https://deb.nodesource.com/setup_20.x -o /tmp/nodesource_setup.sh
RUN bash /tmp/nodesource_setup.sh
RUN apt-get install -y nodejs

# Install Spectral
RUN npm install -g @stoplight/spectral-cli@${SPECTRAL_VERSION}

## Install Redocly
RUN npm install @redocly/cli@${REDOCLY_VERSION} -g

# Install jq
RUN apt-get install -y jq

# Install yq by downloading yq package
RUN mkdir -p /tmp/yq && \
    curl -Lo yq_linux_amd64.tar.gz https://github.com/mikefarah/yq/releases/download/v${YQ_VERSION}/yq_linux_amd64.tar.gz && \
    tar xf yq_linux_amd64.tar.gz --directory /tmp/yq && \
    mv /tmp/yq/yq_linux_amd64 /usr/local/bin/yq && \
    chmod +x /usr/local/bin/yq && \
    rm -rf /tmp/yq yq_linux_amd64.tar.gz

# Install jpp
RUN npm install -g @jsware/jsonpath-cli

# Install Swagger-ui-cli
RUN npm install -g swagger-ui-cli

# Install JDK 20
RUN apt-get install -y openjdk-21-jdk

# Install Maven
RUN apt-get install -y maven

# Install OpenAPI generator CLI
RUN npm install -g @openapitools/openapi-generator-cli@${OPENAPI_GENERATOR_VERSION}

# Install Python3 and pip
RUN apt-get install -y python3 python3-pip

# Install Schemathesis
RUN  pip install schemathesis==${SCHEMATHESIS_VERSION}

# Install Portman
RUN npm install -g @apideck/portman@${PORTMAN_VERSION}

# Install Prism
RUN npm install -g @stoplight/prism-cli@${PRISM_VERSION}

ENV PATH="/usr/local/bin:${PATH}"

# Install Kong Gateway
RUN curl -Lo kong-enterprise-edition-3.5.0.3.deb "https://packages.konghq.com/public/gateway-35/deb/ubuntu/pool/jammy/main/k/ko/kong-enterprise-edition_3.5.0.3/kong-enterprise-edition_3.5.0.3_$(dpkg --print-architecture).deb"
RUN apt-get install -y ./kong-enterprise-edition-3.5.0.3.deb


