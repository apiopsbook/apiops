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
 * ProductsResponseLinks
 */

@JsonTypeName("ProductsResponse_links")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ProductsResponseLinks {

  private URI self;

  private URI first;

  private URI prev;

  private URI next;

  private URI last;

  /**
   * Default constructor
   * @deprecated Use {@link ProductsResponseLinks#ProductsResponseLinks(URI)}
   */
  @Deprecated
  public ProductsResponseLinks() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductsResponseLinks(URI self) {
    this.self = self;
  }

  public ProductsResponseLinks self(URI self) {
    this.self = self;
    return this;
  }

  /**
   * Relative uri cursor pointing to the current page.
   * @return self
  */
  @NotNull @Valid @Size(max = 100) 
  @Schema(name = "self", description = "Relative uri cursor pointing to the current page.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("self")
  public URI getSelf() {
    return self;
  }

  public void setSelf(URI self) {
    this.self = self;
  }

  public ProductsResponseLinks first(URI first) {
    this.first = first;
    return this;
  }

  /**
   * Cursor to the first page.
   * @return first
  */
  @Valid @Size(max = 100) 
  @Schema(name = "first", description = "Cursor to the first page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("first")
  public URI getFirst() {
    return first;
  }

  public void setFirst(URI first) {
    this.first = first;
  }

  public ProductsResponseLinks prev(URI prev) {
    this.prev = prev;
    return this;
  }

  /**
   * Relative uri cursor to the previous page.
   * @return prev
  */
  @Valid @Size(max = 100) 
  @Schema(name = "prev", description = "Relative uri cursor to the previous page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prev")
  public URI getPrev() {
    return prev;
  }

  public void setPrev(URI prev) {
    this.prev = prev;
  }

  public ProductsResponseLinks next(URI next) {
    this.next = next;
    return this;
  }

  /**
   * Relative uri  cursor to the next page.
   * @return next
  */
  @Valid @Size(max = 100) 
  @Schema(name = "next", description = "Relative uri  cursor to the next page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("next")
  public URI getNext() {
    return next;
  }

  public void setNext(URI next) {
    this.next = next;
  }

  public ProductsResponseLinks last(URI last) {
    this.last = last;
    return this;
  }

  /**
   * Relative uri cursor to the last page.
   * @return last
  */
  @Valid 
  @Schema(name = "last", description = "Relative uri cursor to the last page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("last")
  public URI getLast() {
    return last;
  }

  public void setLast(URI last) {
    this.last = last;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductsResponseLinks productsResponseLinks = (ProductsResponseLinks) o;
    return Objects.equals(this.self, productsResponseLinks.self) &&
        Objects.equals(this.first, productsResponseLinks.first) &&
        Objects.equals(this.prev, productsResponseLinks.prev) &&
        Objects.equals(this.next, productsResponseLinks.next) &&
        Objects.equals(this.last, productsResponseLinks.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, first, prev, next, last);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductsResponseLinks {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
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

