package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
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
 * An error response.
 */

@Schema(name = "Error", description = "An error response.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-19T06:47:55.870725+01:00[Europe/London]")
public class Error {

  private UUID id;

  private Integer status;

  private String code;

  private String title;

  private String detail;

  /**
   * Default constructor
   * @deprecated Use {@link Error#Error(Integer, String)}
   */
  @Deprecated
  public Error() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Error(Integer status, String title) {
    this.status = status;
    this.title = title;
  }

  public Error id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * a unique identifier for this particular occurrence of the problem
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "a unique identifier for this particular occurrence of the problem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Error status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * the HTTP status code applicable to this problem
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "the HTTP status code applicable to this problem", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Error code(String code) {
    this.code = code;
    return this;
  }

  /**
   * an application-specific error code
   * @return code
  */
  @Size(max = 100) 
  @Schema(name = "code", description = "an application-specific error code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error title(String title) {
    this.title = title;
    return this;
  }

  /**
   * a short, human-readable summary of the problem that SHOULD NOT change from occurrence to occurrence of the problem, except for purposes of localization
   * @return title
  */
  @NotNull @Size(max = 100) 
  @Schema(name = "title", description = "a short, human-readable summary of the problem that SHOULD NOT change from occurrence to occurrence of the problem, except for purposes of localization", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Error detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * a human-readable explanation specific to this occurrence of the problem. Like title, this field’s value can be localized
   * @return detail
  */
  @Size(max = 150) 
  @Schema(name = "detail", description = "a human-readable explanation specific to this occurrence of the problem. Like title, this field’s value can be localized", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.id, error.id) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.code, error.code) &&
        Objects.equals(this.title, error.title) &&
        Objects.equals(this.detail, error.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, code, title, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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

