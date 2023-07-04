package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.ProductRelationshipsHasReviews;
import com.acmepetsupplies.model.ProductRelationshipsInCategories;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProductRelationships
 */

@JsonTypeName("Product_relationships")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ProductRelationships {

  private ProductRelationshipsInCategories inCategories;

  private ProductRelationshipsHasReviews hasReviews;

  public ProductRelationships inCategories(ProductRelationshipsInCategories inCategories) {
    this.inCategories = inCategories;
    return this;
  }

  /**
   * Get inCategories
   * @return inCategories
  */
  @Valid 
  @Schema(name = "in_categories", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("in_categories")
  public ProductRelationshipsInCategories getInCategories() {
    return inCategories;
  }

  public void setInCategories(ProductRelationshipsInCategories inCategories) {
    this.inCategories = inCategories;
  }

  public ProductRelationships hasReviews(ProductRelationshipsHasReviews hasReviews) {
    this.hasReviews = hasReviews;
    return this;
  }

  /**
   * Get hasReviews
   * @return hasReviews
  */
  @Valid 
  @Schema(name = "has_reviews", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("has_reviews")
  public ProductRelationshipsHasReviews getHasReviews() {
    return hasReviews;
  }

  public void setHasReviews(ProductRelationshipsHasReviews hasReviews) {
    this.hasReviews = hasReviews;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductRelationships productRelationships = (ProductRelationships) o;
    return Objects.equals(this.inCategories, productRelationships.inCategories) &&
        Objects.equals(this.hasReviews, productRelationships.hasReviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inCategories, hasReviews);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRelationships {\n");
    sb.append("    inCategories: ").append(toIndentedString(inCategories)).append("\n");
    sb.append("    hasReviews: ").append(toIndentedString(hasReviews)).append("\n");
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

