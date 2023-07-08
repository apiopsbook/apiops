package com.acmepetsupplies.productcatalog;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EndToEndSchemaTest {


    private final OpenApiValidationFilter validationFilter = new OpenApiValidationFilter("../product-catalog-v1-0.oas.yaml");

    @Test
    public void testGetProductEndToEnd() {
        given()
                .header("X-API-Key", "my_secret_api_key")
                .filter(validationFilter)
                .when()
                .get("http://localhost:8000/v1/catalog/products/612b4280-b5c0-4ad5-bce7-ede7ab2b90fc")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

