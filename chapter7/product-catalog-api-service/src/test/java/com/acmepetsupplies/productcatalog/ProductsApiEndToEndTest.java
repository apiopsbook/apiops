package com.acmepetsupplies.productcatalog;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsApiEndToEndTest {


    @Test
    public void testGetProductEndToEnd() {
        given()
                .header("X-API-Key", "my_secret_api_key")
                .when()
                // .baseUri("http://127.0.0.1:4010")
                .baseUri("http://127.0.0.1:8000")
                .get("/v1/catalog/products/612b4280-b5c0-4ad5-bce7-ede7ab2b90fc")
                .then()
                .log()
                .body()
                .assertThat()
                .statusCode(200);

    }
}

