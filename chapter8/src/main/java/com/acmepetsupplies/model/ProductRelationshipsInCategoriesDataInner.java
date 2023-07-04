package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProductRelationshipsInCategoriesDataInner
 */

@JsonTypeName("Product_relationships_in_categories_data_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ProductRelationshipsInCategoriesDataInner {

  private UUID id;

  private String type;

  public ProductRelationshipsInCategoriesDataInner id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", example = "1e32231d-b8a1-4145-b539-820301c2af64", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ProductRelationshipsInCategoriesDataInner type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Size(max = 8) 
  @Schema(name = "type", example = "category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductRelationshipsInCategoriesDataInner productRelationshipsInCategoriesDataInner = (ProductRelationshipsInCategoriesDataInner) o;
    return Objects.equals(this.id, productRelationshipsInCategoriesDataInner.id) &&
        Objects.equals(this.type, productRelationshipsInCategoriesDataInner.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRelationshipsInCategoriesDataInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

