package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.acmepetsupplies.model.ErrorErrorsInnerLinks;
import com.acmepetsupplies.model.ErrorErrorsInnerSource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * A JSON:API-compliant error object.
 */

@Schema(name = "Error_errors_inner", description = "A JSON:API-compliant error object.")
@JsonTypeName("Error_errors_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ErrorErrorsInner {

  private UUID id;

  private ErrorErrorsInnerLinks links;

  private Integer status;

  private String code;

  private String title;

  private String detail;

  private ErrorErrorsInnerSource source;

  private Object meta;

  /**
   * Default constructor
   * @deprecated Use {@link ErrorErrorsInner#ErrorErrorsInner(Integer, String)}
   */
  @Deprecated
  public ErrorErrorsInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorErrorsInner(Integer status, String title) {
    this.status = status;
    this.title = title;
  }

  public ErrorErrorsInner id(UUID id) {
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

  public ErrorErrorsInner links(ErrorErrorsInnerLinks links) {
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
  public ErrorErrorsInnerLinks getLinks() {
    return links;
  }

  public void setLinks(ErrorErrorsInnerLinks links) {
    this.links = links;
  }

  public ErrorErrorsInner status(Integer status) {
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

  public ErrorErrorsInner code(String code) {
    this.code = code;
    return this;
  }

  /**
   * an application-specific error code
   * @return code
  */
  @Size(max = 10) 
  @Schema(name = "code", description = "an application-specific error code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorErrorsInner title(String title) {
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

  public ErrorErrorsInner detail(String detail) {
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

  public ErrorErrorsInner source(ErrorErrorsInnerSource source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
  */
  @Valid 
  @Schema(name = "source", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("source")
  public ErrorErrorsInnerSource getSource() {
    return source;
  }

  public void setSource(ErrorErrorsInnerSource source) {
    this.source = source;
  }

  public ErrorErrorsInner meta(Object meta) {
    this.meta = meta;
    return this;
  }

  /**
   * a JSON meta object with non-standard meta-information about the error
   * @return meta
  */
  
  @Schema(name = "meta", description = "a JSON meta object with non-standard meta-information about the error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("meta")
  public Object getMeta() {
    return meta;
  }

  public void setMeta(Object meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorErrorsInner errorErrorsInner = (ErrorErrorsInner) o;
    return Objects.equals(this.id, errorErrorsInner.id) &&
        Objects.equals(this.links, errorErrorsInner.links) &&
        Objects.equals(this.status, errorErrorsInner.status) &&
        Objects.equals(this.code, errorErrorsInner.code) &&
        Objects.equals(this.title, errorErrorsInner.title) &&
        Objects.equals(this.detail, errorErrorsInner.detail) &&
        Objects.equals(this.source, errorErrorsInner.source) &&
        Objects.equals(this.meta, errorErrorsInner.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, links, status, code, title, detail, source, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorErrorsInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

