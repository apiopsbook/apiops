package com.acmepetsupplies.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "com.acmepetsupplies.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Product Catalog API")
                                .description("The Product Catalog API enables customers browse Acme Pet Supplies great range of pet products and their product reviews.")
                                .contact(
                                        new Contact()
                                                .name("John Smith")
                                                .url("https://acme-pet-supplies.com/docs")
                                                .email("john.smith@acme-pet-supplies.com")
                                )
                                .version("1.0")
                )
                .components(
                        new Components()
                                .addSecuritySchemes("ApiKeyAuth", new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)
                                        .name("x-api-key")
                                )
                )
        ;
    }
}