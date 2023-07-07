package com.acmepetsupplies.productcatalog.model;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Schema(name = "Product", description = "An item in Acme's pet supplies catalog.")
public class Product {


    private UUID id;


    private String name;


    private String description;


    private BigDecimal price;


    private Set<String> keywords = new LinkedHashSet<>();


    private Integer reviewRating;


    private Integer numberOfReviews;

    public Product id(UUID id) {
        this.id = id;
        return this;
    }

    @NotNull
    @Valid
    @Schema(name = "id", example = "dcd53ddb-8104-4e48-8cc0-5df1088c6113", description = "Identifier for the product.", required = true)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }


    @NotNull
    @Size(min = 1, max = 50)
    @Schema(name = "name", example = "Acme Uber Dog Rope Toy", description = "Name of the product.", required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }


    @NotNull
    @Size(min = 0, max = 300)
    @Schema(name = "description", example = "Acme Uber Dog Rope Toy provides hours of fun for your dog. Great for bouncing, throwing and catching.", description = "A description of the product.", required = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product price(BigDecimal price) {
        this.price = price;
        return this;
    }


    @NotNull
    @Valid
    @DecimalMin("0")
    @DecimalMax("1000000")
    @Schema(name = "price", example = "100", description = "Price of the product.", required = true)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product keywords(Set<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public Product addKeywordsItem(String keywordsItem) {
        this.keywords.add(keywordsItem);
        return this;
    }


    @NotNull
    @Size(min = 0, max = 20)
    @Schema(name = "keywords", description = "A collection of words that describe the product, used for searching for it.", example = "[\"rope\", \"toy\"]", requiredMode = Schema.RequiredMode.REQUIRED)
    public Set<String> getKeywords() {
        return keywords;
    }


    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public Product reviewRating(Integer reviewRating) {
        this.reviewRating = reviewRating;
        return this;
    }


    @NotNull
    @Min(1)
    @Max(5)
    @Schema(name = "reviewRating", example = "5", description = "Average product review rating.", requiredMode = Schema.RequiredMode.REQUIRED)
    public Integer getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(Integer reviewRating) {
        this.reviewRating = reviewRating;
    }

    public Product numberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
        return this;
    }


    @NotNull
    @Schema(name = "numberOfReviews", example = "10", description = "Number of product reviews.", required = true)
    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.name, product.name) &&
                Objects.equals(this.description, product.description) &&
                Objects.equals(this.price, product.price) &&
                Objects.equals(this.keywords, product.keywords) &&
                Objects.equals(this.reviewRating, product.reviewRating) &&
                Objects.equals(this.numberOfReviews, product.numberOfReviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, keywords, reviewRating, numberOfReviews);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    keywords: ").append(toIndentedString(keywords)).append("\n");
        sb.append("    reviewRating: ").append(toIndentedString(reviewRating)).append("\n");
        sb.append("    numberOfReviews: ").append(toIndentedString(numberOfReviews)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

