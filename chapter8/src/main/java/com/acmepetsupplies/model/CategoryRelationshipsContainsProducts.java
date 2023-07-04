package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.CategoryRelationshipsContainsProductsLink;
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
 * CategoryRelationshipsContainsProducts
 */

@JsonTypeName("Category_relationships_contains_products")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class CategoryRelationshipsContainsProducts {

  private CategoryRelationshipsContainsProductsLink link;

  public CategoryRelationshipsContainsProducts link(CategoryRelationshipsContainsProductsLink link) {
    this.link = link;
    return this;
  }

  /**
   * Get link
   * @return link
  */
  @Valid 
  @Schema(name = "link", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("link")
  public CategoryRelationshipsContainsProductsLink getLink() {
    return link;
  }

  public void setLink(CategoryRelationshipsContainsProductsLink link) {
    this.link = link;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryRelationshipsContainsProducts categoryRelationshipsContainsProducts = (CategoryRelationshipsContainsProducts) o;
    return Objects.equals(this.link, categoryRelationshipsContainsProducts.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRelationshipsContainsProducts {\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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

