package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.ReviewAttributes;
import com.acmepetsupplies.model.ReviewRelationships;
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
 * A review for a product.
 */

@Schema(name = "Review", description = "A review for a product.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class Review {

  private UUID id;

  private String type;

  private ReviewAttributes attributes;

  private ReviewRelationships relationships;

  public Review id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier for a product review.
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "Identifier for a product review.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Review type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Size(max = 6) 
  @Schema(name = "type", example = "review", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Review attributes(ReviewAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

  /**
   * Get attributes
   * @return attributes
  */
  @Valid 
  @Schema(name = "attributes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attributes")
  public ReviewAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(ReviewAttributes attributes) {
    this.attributes = attributes;
  }

  public Review relationships(ReviewRelationships relationships) {
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
  public ReviewRelationships getRelationships() {
    return relationships;
  }

  public void setRelationships(ReviewRelationships relationships) {
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
    Review review = (Review) o;
    return Objects.equals(this.id, review.id) &&
        Objects.equals(this.type, review.type) &&
        Objects.equals(this.attributes, review.attributes) &&
        Objects.equals(this.relationships, review.relationships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, attributes, relationships);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Review {\n");
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

