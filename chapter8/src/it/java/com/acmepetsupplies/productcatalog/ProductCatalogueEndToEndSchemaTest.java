package com.acmepetsupplies.productcatalog;

import io.restassured.filter.Filter;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductCatalogueEndToEndSchemaTest {


    private final Filter validationFilter = new ResponseOnlyValidationFilter("http://localhost:9090/apis/registry/v2/groups/acmeapis/artifacts/productsapi");

    @Test
    public void testGetProductEndToEnd() {
        given()
                .header("Authorization", "Bearer test_token")
                .filter(validationFilter)
                .when()
                .get("http://localhost:8000/v1/catalog/products/612b4280-b5c0-4ad5-bce7-ede7ab2b90fc")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testBadRequest() {
        given()
                .header("Authorization", "Bearer test_token")
                .filter(validationFilter)
                .when()
                .get("http://localhost:8000/v1/catalog/products/bad-uuid")
                .then()
                .assertThat()
                .statusCode(400);
    }

}

