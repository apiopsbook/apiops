package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.CategoryAttributes;
import com.acmepetsupplies.model.CategoryRelationships;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * A product category.
 */

@Schema(name = "Category", description = "A product category.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class Category {

  private UUID id;

  private String type;

  private CategoryAttributes attributes;

  private CategoryRelationships relationships;

  /**
   * Default constructor
   * @deprecated Use {@link Category#Category(UUID, String, CategoryAttributes)}
   */
  @Deprecated
  public Category() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Category(UUID id, String type, CategoryAttributes attributes) {
    this.id = id;
    this.type = type;
    this.attributes = attributes;
  }

  public Category id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the category.
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", example = "1e32231d-b8a1-4145-b539-820301c2af64", description = "Identifier of the category.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Category type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Size(max = 8) 
  @Schema(name = "type", example = "category", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Category attributes(CategoryAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

  /**
   * Get attributes
   * @return attributes
  */
  @NotNull @Valid 
  @Schema(name = "attributes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributes")
  public CategoryAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(CategoryAttributes attributes) {
    this.attributes = attributes;
  }

  public Category relationships(CategoryRelationships relationships) {
    this.relationships = relationships;
    return this;
  }

  /**
   * Get relationships
   * @return relationships
  */
  @Valid 
  @Schema(name = "relationships", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("relationships")
  public CategoryRelationships getRelationships() {
    return relationships;
  }

  public void setRelationships(CategoryRelationships relationships) {
    this.relationships = relationships;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.id, category.id) &&
        Objects.equals(this.type, category.type) &&
        Objects.equals(this.attributes, category.attributes) &&
        Objects.equals(this.relationships, category.relationships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, attributes, relationships);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
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

