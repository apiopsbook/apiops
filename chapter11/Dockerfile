FROM kong:latest
USER root
RUN luarocks install --server=http://luarocks.org/manifests/moesif kong-plugin-moesif
USER kong