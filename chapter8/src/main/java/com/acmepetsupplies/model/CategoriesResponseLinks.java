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
 * CategoriesResponseLinks
 */

@JsonTypeName("CategoriesResponse_links")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class CategoriesResponseLinks {

  private URI self;

  private URI first;

  private URI prev;

  private URI next;

  private URI last;

  /**
   * Default constructor
   * @deprecated Use {@link CategoriesResponseLinks#CategoriesResponseLinks(URI)}
   */
  @Deprecated
  public CategoriesResponseLinks() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategoriesResponseLinks(URI self) {
    this.self = self;
  }

  public CategoriesResponseLinks self(URI self) {
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

  public CategoriesResponseLinks first(URI first) {
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

  public CategoriesResponseLinks prev(URI prev) {
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

  public CategoriesResponseLinks next(URI next) {
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

  public CategoriesResponseLinks last(URI last) {
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
    CategoriesResponseLinks categoriesResponseLinks = (CategoriesResponseLinks) o;
    return Objects.equals(this.self, categoriesResponseLinks.self) &&
        Objects.equals(this.first, categoriesResponseLinks.first) &&
        Objects.equals(this.prev, categoriesResponseLinks.prev) &&
        Objects.equals(this.next, categoriesResponseLinks.next) &&
        Objects.equals(this.last, categoriesResponseLinks.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, first, prev, next, last);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoriesResponseLinks {\n");
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

