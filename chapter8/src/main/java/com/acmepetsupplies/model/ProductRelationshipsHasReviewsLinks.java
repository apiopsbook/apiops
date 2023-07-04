package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
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
 * ProductRelationshipsHasReviewsLinks
 */

@JsonTypeName("Product_relationships_has_reviews_links")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ProductRelationshipsHasReviewsLinks {

  private String related;

  public ProductRelationshipsHasReviewsLinks related(String related) {
    this.related = related;
    return this;
  }

  /**
   * Get related
   * @return related
  */
  @Size(max = 100) 
  @Schema(name = "related", example = "https://api.acme-pet-supplies.com/v1/catalog/products/dcd53ddb-8104-4e48-8cc0-5df1088c6113/reviews", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("related")
  public String getRelated() {
    return related;
  }

  public void setRelated(String related) {
    this.related = related;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductRelationshipsHasReviewsLinks productRelationshipsHasReviewsLinks = (ProductRelationshipsHasReviewsLinks) o;
    return Objects.equals(this.related, productRelationshipsHasReviewsLinks.related);
  }

  @Override
  public int hashCode() {
    return Objects.hash(related);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRelationshipsHasReviewsLinks {\n");
    sb.append("    related: ").append(toIndentedString(related)).append("\n");
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

