package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.Category;
import com.acmepetsupplies.model.Product;
import com.acmepetsupplies.model.ProductsResponseLinks;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProductsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ProductsResponse {

  @Valid
  private List<@Valid Product> data;

  @Valid
  private Set<@Valid Category> included;

  private ProductsResponseLinks links;

  public ProductsResponse data(List<@Valid Product> data) {
    this.data = data;
    return this;
  }

  public ProductsResponse addDataItem(Product dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * 
   * @return data
  */
  @Valid @Size(max = 25) 
  @Schema(name = "data", description = "", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public List<@Valid Product> getData() {
    return data;
  }

  public void setData(List<@Valid Product> data) {
    this.data = data;
  }

  public ProductsResponse included(Set<@Valid Category> included) {
    this.included = included;
    return this;
  }

  public ProductsResponse addIncludedItem(Category includedItem) {
    if (this.included == null) {
      this.included = new LinkedHashSet<>();
    }
    this.included.add(includedItem);
    return this;
  }

  /**
   * Get included
   * @return included
  */
  @Valid 
  @Schema(name = "included", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("included")
  public Set<@Valid Category> getIncluded() {
    return included;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setIncluded(Set<@Valid Category> included) {
    this.included = included;
  }

  public ProductsResponse links(ProductsResponseLinks links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
  */
  @Valid 
  @Schema(name = "links", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("links")
  public ProductsResponseLinks getLinks() {
    return links;
  }

  public void setLinks(ProductsResponseLinks links) {
    this.links = links;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductsResponse productsResponse = (ProductsResponse) o;
    return Objects.equals(this.data, productsResponse.data) &&
        Objects.equals(this.included, productsResponse.included) &&
        Objects.equals(this.links, productsResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, included, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductsResponse {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    included: ").append(toIndentedString(included)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

