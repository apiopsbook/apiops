package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.Review;
import com.acmepetsupplies.model.ReviewsResponseLinks;
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
 * ReviewsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ReviewsResponse {

  @Valid
  private List<@Valid Review> data = new ArrayList<>();

  private ReviewsResponseLinks links;

  /**
   * Default constructor
   * @deprecated Use {@link ReviewsResponse#ReviewsResponse(List<@Valid Review>, ReviewsResponseLinks)}
   */
  @Deprecated
  public ReviewsResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ReviewsResponse(List<@Valid Review> data, ReviewsResponseLinks links) {
    this.data = data;
    this.links = links;
  }

  public ReviewsResponse data(List<@Valid Review> data) {
    this.data = data;
    return this;
  }

  public ReviewsResponse addDataItem(Review dataItem) {
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
  @NotNull @Valid @Size(max = 25) 
  @Schema(name = "data", description = "", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public List<@Valid Review> getData() {
    return data;
  }

  public void setData(List<@Valid Review> data) {
    this.data = data;
  }

  public ReviewsResponse links(ReviewsResponseLinks links) {
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
  public ReviewsResponseLinks getLinks() {
    return links;
  }

  public void setLinks(ReviewsResponseLinks links) {
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
    ReviewsResponse reviewsResponse = (ReviewsResponse) o;
    return Objects.equals(this.data, reviewsResponse.data) &&
        Objects.equals(this.links, reviewsResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReviewsResponse {\n");
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

