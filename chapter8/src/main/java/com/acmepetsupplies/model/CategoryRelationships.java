package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.CategoryRelationshipsContainsProducts;
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
 * CategoryRelationships
 */

@JsonTypeName("Category_relationships")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class CategoryRelationships {

  private CategoryRelationshipsContainsProducts containsProducts;

  public CategoryRelationships containsProducts(CategoryRelationshipsContainsProducts containsProducts) {
    this.containsProducts = containsProducts;
    return this;
  }

  /**
   * Get containsProducts
   * @return containsProducts
  */
  @Valid 
  @Schema(name = "contains_products", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contains_products")
  public CategoryRelationshipsContainsProducts getContainsProducts() {
    return containsProducts;
  }

  public void setContainsProducts(CategoryRelationshipsContainsProducts containsProducts) {
    this.containsProducts = containsProducts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryRelationships categoryRelationships = (CategoryRelationships) o;
    return Objects.equals(this.containsProducts, categoryRelationships.containsProducts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containsProducts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRelationships {\n");
    sb.append("    containsProducts: ").append(toIndentedString(containsProducts)).append("\n");
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

