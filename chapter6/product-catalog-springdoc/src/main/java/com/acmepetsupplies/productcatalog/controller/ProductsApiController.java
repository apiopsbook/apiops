package com.acmepetsupplies.productcatalog.controller;

import com.acmepetsupplies.productcatalog.model.ApiError;
import com.acmepetsupplies.productcatalog.model.Product;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
public class ProductsApiController {


    @GetMapping(value = "/v1/catalog/products/{id}", produces = {"application/json"})
    @Tag(name = "Products")
    @Operation(
            operationId = "viewProduct",
            summary = "View a product's details",
            tags = {"Products"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class),
                                    examples = {@ExampleObject(value = "{\"title\": \"Bad Request\", \"status\": \"400\", " +
                                            "\"detail\": \"Bad request. Please check the request is valid.\", " +
                                            "\"id\": \"0b1bbf0e-d8c7-4cc6-9257-bedd8c9dcadf\" }")})
                    }),
                    @ApiResponse(responseCode = "401", description = "Not authorized", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class),
                                    examples = {@ExampleObject(value = "{\"title\": \"Not authorized\", \"status\": \"401\", " +
                                            "\"detail\": \"Authentication failure.\", " +
                                            "\"id\": \"8011c394-30c9-11ed-a261-0242ac120002\" }")})
                    }),
                    @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class),
                                    examples = {@ExampleObject(value = "{\"title\": \"Forbidden\", \"status\": \"403\", " +
                                            "\"detail\": \"Access to this resource is forbidden.\", " +
                                            "\"id\": \"747c7b00-30c9-11ed-a261-0242ac120002\" }")})
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class),
                                    examples = {@ExampleObject(value = "{\"title\": \"Not Found\", \"status\": \"404\", " +
                                            "\"detail\": \"Resource not found.\", " +
                                            "\"id\": \"6c4a6b54-30c9-11ed-a261-0242ac120002\" }")})
                    }),
            },
            security = {
                    @SecurityRequirement(name = "ApiKeyAuth")
            }
    )
    public ResponseEntity<Product> viewProduct(@Valid  @PathVariable("id") UUID id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Acme Uber Dog Rope Toy");
        product.setDescription("Acme Uber Dog Rope Toy provides hours of fun for your dog.");
        product.setPrice(new BigDecimal(50));
        Set<String> keywords = new HashSet<>(Arrays.asList("rope", "toy", "dog"));
        product.setKeywords(keywords);
        product.setNumberOfReviews(11);
        product.setReviewRating(3);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}