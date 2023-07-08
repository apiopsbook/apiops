package com.acmepetsupplies.productcatalog;

import com.acmepetsupplies.productcatalog.controller.ProductsApiController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@SpringBootTest
public class ControllerSchemaTest {

    @Test
    public void testGetProductController() {
        given()
                .standaloneSetup(new ProductsApiController())
                .when()
                .get("/v1/catalog/products/612b4280-b5c0-4ad5-bce7-ede7ab2b90fc")
                .then()
                .assertThat()
                .expect(openApi().isValid("../product-catalog-v1-0.oas.yaml"))
                .statusCode(200);
    }

}
