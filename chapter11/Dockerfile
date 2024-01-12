FROM kong:latest
USER root
RUN luarocks install --server=http://luarocks.org/manifests/moesif kong-plugin-moesif
RUN apt-get update \
    && apt-get install -y curl jq
USER kong