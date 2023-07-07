package com.acmepetsupplies.productcatalog;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
//
//    @Bean
//    OpenAPI apiInfo() {
//        return new OpenAPI()
//                .info(
//                        new Info()
//                                .title("Product Catalog API")
//                                .description("The Product Catalog API enables customers browse Acme Pet Supplies great range of pet products and their product reviews. ")
//                                .contact(
//                                        new Contact()
//                                                .name("John Smith")
//                                                .url("https:acme-pet-supplies.co.uk/docs")
//                                                .email("john.smith@acme-pet-supplies.co.uk")
//                                )
//                                .version("1.0")
//                )
//                .components(
//                        new Components()
//                                .addSecuritySchemes("ApiKeyAuth", new SecurityScheme()
//                                        .type(SecurityScheme.Type.APIKEY)
//                                        .name("x-api-key")
//                                        .in(SecurityScheme.In.HEADER)
//                                )
//                )
//        ;
//    }
}