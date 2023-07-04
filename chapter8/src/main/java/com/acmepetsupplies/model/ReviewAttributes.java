package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ReviewAttributes
 */

@JsonTypeName("Review_attributes")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ReviewAttributes {

  private String content;

  private Integer rating;

  private String authorName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime submittedDate;

  /**
   * Default constructor
   * @deprecated Use {@link ReviewAttributes#ReviewAttributes(String, Integer, String, OffsetDateTime)}
   */
  @Deprecated
  public ReviewAttributes() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ReviewAttributes(String content, Integer rating, String authorName, OffsetDateTime submittedDate) {
    this.content = content;
    this.rating = rating;
    this.authorName = authorName;
    this.submittedDate = submittedDate;
  }

  public ReviewAttributes content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Review content.
   * @return content
  */
  @NotNull @Size(min = 0, max = 500) 
  @Schema(name = "content", example = "This dog toy is great! My dog loved to play with it. I thoroughly recommend.", description = "Review content.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public ReviewAttributes rating(Integer rating) {
    this.rating = rating;
    return this;
  }

  /**
   * The rating of the review. A number in the range 1 to 5, 1 for lowest and 5 for highest.
   * minimum: 1
   * maximum: 5
   * @return rating
  */
  @NotNull @Min(1) @Max(5) 
  @Schema(name = "rating", example = "5", description = "The rating of the review. A number in the range 1 to 5, 1 for lowest and 5 for highest.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("rating")
  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public ReviewAttributes authorName(String authorName) {
    this.authorName = authorName;
    return this;
  }

  /**
   * Name of the author of the review.
   * @return authorName
  */
  @NotNull @Size(max = 30) 
  @Schema(name = "authorName", example = "Jill Baker", description = "Name of the author of the review.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("authorName")
  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public ReviewAttributes submittedDate(OffsetDateTime submittedDate) {
    this.submittedDate = submittedDate;
    return this;
  }

  /**
   * Date the review was submitted.
   * @return submittedDate
  */
  @NotNull @Valid 
  @Schema(name = "submittedDate", example = "2022-04-12T23:20:50.520Z", description = "Date the review was submitted.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("submittedDate")
  public OffsetDateTime getSubmittedDate() {
    return submittedDate;
  }

  public void setSubmittedDate(OffsetDateTime submittedDate) {
    this.submittedDate = submittedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReviewAttributes reviewAttributes = (ReviewAttributes) o;
    return Objects.equals(this.content, reviewAttributes.content) &&
        Objects.equals(this.rating, reviewAttributes.rating) &&
        Objects.equals(this.authorName, reviewAttributes.authorName) &&
        Objects.equals(this.submittedDate, reviewAttributes.submittedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, rating, authorName, submittedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReviewAttributes {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    authorName: ").append(toIndentedString(authorName)).append("\n");
    sb.append("    submittedDate: ").append(toIndentedString(submittedDate)).append("\n");
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

