docker run -d --name kong-dbless ^
  -v %cd%:/kong/declarative/ ^
  -e "KONG_DATABASE=off" ^
  -e "KONG_DECLARATIVE_CONFIG=/kong/declarative/kong.yml" ^
  -e "KONG_PROXY_ACCESS_LOG=/kong/declarative/proxy_access.log" ^
  -e "KONG_ADMIN_ACCESS_LOG=/dev/stdout" ^
  -e "KONG_PROXY_ERROR_LOG=/kong/declarative/proxy_error.log" ^
  -e "KONG_ADMIN_ERROR_LOG=/dev/stderr" ^
  -e "KONG_ADMIN_LISTEN=0.0.0.0:8001, 0.0.0.0:8444 ssl" ^
  -p 8000:8000 ^
  -p 8443:8443 ^
  -p 127.0.0.1:8001:8001 ^
  -p 127.0.0.1:8444:8444 ^
  kong/kong-gateway:3.3.1.0