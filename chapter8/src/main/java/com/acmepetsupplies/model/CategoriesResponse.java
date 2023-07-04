package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.CategoriesResponseLinks;
import com.acmepetsupplies.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CategoriesResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class CategoriesResponse {

  @Valid
  private List<@Valid Category> data = new ArrayList<>();

  private CategoriesResponseLinks links;

  /**
   * Default constructor
   * @deprecated Use {@link CategoriesResponse#CategoriesResponse(List<@Valid Category>, CategoriesResponseLinks)}
   */
  @Deprecated
  public CategoriesResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategoriesResponse(List<@Valid Category> data, CategoriesResponseLinks links) {
    this.data = data;
    this.links = links;
  }

  public CategoriesResponse data(List<@Valid Category> data) {
    this.data = data;
    return this;
  }

  public CategoriesResponse addDataItem(Category dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid @Size(max = 25) 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public List<@Valid Category> getData() {
    return data;
  }

  public void setData(List<@Valid Category> data) {
    this.data = data;
  }

  public CategoriesResponse links(CategoriesResponseLinks links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
  */
  @NotNull @Valid 
  @Schema(name = "links", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("links")
  public CategoriesResponseLinks getLinks() {
    return links;
  }

  public void setLinks(CategoriesResponseLinks links) {
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
    CategoriesResponse categoriesResponse = (CategoriesResponse) o;
    return Objects.equals(this.data, categoriesResponse.data) &&
        Objects.equals(this.links, categoriesResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoriesResponse {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

