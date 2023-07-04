package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProductAttributes
 */

@JsonTypeName("Product_attributes")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ProductAttributes {

  private String name;

  private String description;

  private BigDecimal price;

  @Valid
  private Set<String> keywords;

  private Integer reviewRating;

  private Integer numberOfReviews;

  public ProductAttributes name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product.
   * @return name
  */
  @Size(min = 1, max = 50) 
  @Schema(name = "name", example = "Acme Uber Dog Rope Toy", description = "Name of the product.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductAttributes description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the product.
   * @return description
  */
  @Size(min = 0, max = 300) 
  @Schema(name = "description", example = "Acme Uber Dog Rope Toy provides hours of fun for your dog. Great for bouncing, throwing and catching. ", description = "A description of the product.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductAttributes price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Price of the product.
   * minimum: 0
   * maximum: 1000000
   * @return price
  */
  @Valid @DecimalMin("0") @DecimalMax("1000000") 
  @Schema(name = "price", example = "100", description = "Price of the product.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public ProductAttributes keywords(Set<String> keywords) {
    this.keywords = keywords;
    return this;
  }

  public ProductAttributes addKeywordsItem(String keywordsItem) {
    if (this.keywords == null) {
      this.keywords = new LinkedHashSet<>();
    }
    this.keywords.add(keywordsItem);
    return this;
  }

  /**
   * A colleciton of words that describe the product, used for searching for it.
   * @return keywords
  */
  @Size(min = 0, max = 20) 
  @Schema(name = "keywords", description = "A colleciton of words that describe the product, used for searching for it.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("keywords")
  public Set<String> getKeywords() {
    return keywords;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setKeywords(Set<String> keywords) {
    this.keywords = keywords;
  }

  public ProductAttributes reviewRating(Integer reviewRating) {
    this.reviewRating = reviewRating;
    return this;
  }

  /**
   * Average product review rating.
   * minimum: 1
   * maximum: 5
   * @return reviewRating
  */
  @Min(1) @Max(5) 
  @Schema(name = "reviewRating", example = "5", description = "Average product review rating.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reviewRating")
  public Integer getReviewRating() {
    return reviewRating;
  }

  public void setReviewRating(Integer reviewRating) {
    this.reviewRating = reviewRating;
  }

  public ProductAttributes numberOfReviews(Integer numberOfReviews) {
    this.numberOfReviews = numberOfReviews;
    return this;
  }

  /**
   * Number of product reviews.
   * @return numberOfReviews
  */
  
  @Schema(name = "numberOfReviews", example = "10", description = "Number of product reviews.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numberOfReviews")
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
    ProductAttributes productAttributes = (ProductAttributes) o;
    return Objects.equals(this.name, productAttributes.name) &&
        Objects.equals(this.description, productAttributes.description) &&
        Objects.equals(this.price, productAttributes.price) &&
        Objects.equals(this.keywords, productAttributes.keywords) &&
        Objects.equals(this.reviewRating, productAttributes.reviewRating) &&
        Objects.equals(this.numberOfReviews, productAttributes.numberOfReviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, keywords, reviewRating, numberOfReviews);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductAttributes {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    keywords: ").append(toIndentedString(keywords)).append("\n");
    sb.append("    reviewRating: ").append(toIndentedString(reviewRating)).append("\n");
    sb.append("    numberOfReviews: ").append(toIndentedString(numberOfReviews)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

