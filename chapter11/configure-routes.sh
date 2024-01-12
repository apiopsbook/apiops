curl -v -X POST \
    --url http://localhost:8001/services/ \
    --data 'name=Product_Catalog_API_Sandbox' \
    --data 'url=http://prism:4010'

 curl -v -X POST \
  --url http://localhost:8001/services/Product_Catalog_API_Sandbox/routes/ \
  --data 'paths[]=/sandbox' \
  --data name=v1_catalog_sandbox \
  --data strip_path=true

curl -v -X POST \
    --url http://localhost:8001/services/ \
    --data 'name=Product_Catalog_API' \
    --data 'url=http://prism:4010'

 curl -v -X POST \
  --url http://localhost:8001/services/Product_Catalog_API_Sandbox/routes/ \
  --data 'paths[]=/api' \
  --data name=v1_catalog \
  --data strip_path=true


