package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.ProductAttributes;
import com.acmepetsupplies.model.ProductRelationships;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * An item in Acme&#39;s pet supplies catalog.
 */

@Schema(name = "Product", description = "An item in Acme's pet supplies catalog.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class Product {

  private String id;

  private String type;

  private ProductAttributes attributes;

  private ProductRelationships relationships;

  /**
   * Default constructor
   * @deprecated Use {@link Product#Product(String, String, ProductAttributes, ProductRelationships)}
   */
  @Deprecated
  public Product() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Product(String id, String type, ProductAttributes attributes, ProductRelationships relationships) {
    this.id = id;
    this.type = type;
    this.attributes = attributes;
    this.relationships = relationships;
  }

  public Product id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier for the product.
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "dcd53ddb-8104-4e48-8cc0-5df1088c6113", description = "Identifier for the product.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Product type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Size(max = 7) 
  @Schema(name = "type", example = "product", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Product attributes(ProductAttributes attributes) {
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
  public ProductAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(ProductAttributes attributes) {
    this.attributes = attributes;
  }

  public Product relationships(ProductRelationships relationships) {
    this.relationships = relationships;
    return this;
  }

  /**
   * Get relationships
   * @return relationships
  */
  @NotNull @Valid 
  @Schema(name = "relationships", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("relationships")
  public ProductRelationships getRelationships() {
    return relationships;
  }

  public void setRelationships(ProductRelationships relationships) {
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
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.type, product.type) &&
        Objects.equals(this.attributes, product.attributes) &&
        Objects.equals(this.relationships, product.relationships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, attributes, relationships);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
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

