package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.ReviewRelationshipsForProduct;
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
 * ReviewRelationships
 */

@JsonTypeName("Review_relationships")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ReviewRelationships {

  private ReviewRelationshipsForProduct forProduct;

  public ReviewRelationships forProduct(ReviewRelationshipsForProduct forProduct) {
    this.forProduct = forProduct;
    return this;
  }

  /**
   * Get forProduct
   * @return forProduct
  */
  @Valid 
  @Schema(name = "for_product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("for_product")
  public ReviewRelationshipsForProduct getForProduct() {
    return forProduct;
  }

  public void setForProduct(ReviewRelationshipsForProduct forProduct) {
    this.forProduct = forProduct;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReviewRelationships reviewRelationships = (ReviewRelationships) o;
    return Objects.equals(this.forProduct, reviewRelationships.forProduct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forProduct);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReviewRelationships {\n");
    sb.append("    forProduct: ").append(toIndentedString(forProduct)).append("\n");
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

