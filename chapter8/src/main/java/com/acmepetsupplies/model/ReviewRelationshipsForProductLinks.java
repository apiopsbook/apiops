package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.net.URI;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ReviewRelationshipsForProductLinks
 */

@JsonTypeName("Review_relationships_for_product_links")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ReviewRelationshipsForProductLinks {

  private URI related;

  public ReviewRelationshipsForProductLinks related(URI related) {
    this.related = related;
    return this;
  }

  /**
   * Get related
   * @return related
  */
  @Valid @Size(max = 100) 
  @Schema(name = "related", example = "https://api.acme-pet-supplies.com/v1/catalog/products/dcd53ddb-8104-4e48-8cc0-5df1088c6113", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("related")
  public URI getRelated() {
    return related;
  }

  public void setRelated(URI related) {
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
    ReviewRelationshipsForProductLinks reviewRelationshipsForProductLinks = (ReviewRelationshipsForProductLinks) o;
    return Objects.equals(this.related, reviewRelationshipsForProductLinks.related);
  }

  @Override
  public int hashCode() {
    return Objects.hash(related);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReviewRelationshipsForProductLinks {\n");
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

