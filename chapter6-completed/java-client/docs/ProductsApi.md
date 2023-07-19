# ProductsApi

All URIs are relative to *http://api.acme-pet-supplies.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**viewProduct**](ProductsApi.md#viewProduct) | **GET** /v1/catalog/products/{id} | View a product&#39;s details |


<a id="viewProduct"></a>
# **viewProduct**
> Product viewProduct(id)

View a product&#39;s details

View a product&#39;s details.

### Example
```java
// Import classes:
import com.acmepetsupplies.client.ApiClient;
import com.acmepetsupplies.client.ApiException;
import com.acmepetsupplies.client.Configuration;
import com.acmepetsupplies.client.auth.*;
import com.acmepetsupplies.client.models.*;
import com.acmepetsupplies.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://api.acme-pet-supplies.com");
    
    // Configure API key authorization: ApiKeyAuth
    ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
    ApiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //ApiKeyAuth.setApiKeyPrefix("Token");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    UUID id = UUID.fromString("c05aed25-97cd-4cbc-b299-3796538eee9c"); // UUID | Product identifier
    try {
      Product result = apiInstance.viewProduct(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#viewProduct");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **UUID**| Product identifier | |

### Return type

[**Product**](Product.md)

### Authorization

[ApiKeyAuth](../README.md#ApiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Not authorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |

