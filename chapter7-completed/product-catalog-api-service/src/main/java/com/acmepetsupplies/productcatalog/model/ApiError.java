package com.acmepetsupplies.productcatalog.model;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Objects;
import java.util.UUID;



@Schema(name = "Error", description = "An error response.")
public class ApiError {


  private UUID id;


  private Integer status;


  private String code;


  private String title;


  private String detail;

  public ApiError id(UUID id) {
    this.id = id;
    return this;
  }


  @Valid
  @Schema(name = "id", description = "a unique identifier for this particular occurrence of the problem", required = false)
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ApiError status(Integer status) {
    this.status = status;
    return this;
  }


  @NotNull
  @Schema(name = "status", description = "the HTTP status code applicable to this problem", required = true)
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ApiError code(String code) {
    this.code = code;
    return this;
  }


  @Size(max = 10)
  @Schema(name = "code", description = "an application-specific error code", required = false)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ApiError title(String title) {
    this.title = title;
    return this;
  }


  @NotNull @Size(max = 100)
  @Schema(name = "title", description = "a short, human-readable summary of the problem that SHOULD NOT change from occurrence to occurrence of the problem, except for purposes of localization", required = true)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ApiError detail(String detail) {
    this.detail = detail;
    return this;
  }


  @Size(max = 150)
  @Schema(name = "detail", description = "a human-readable explanation specific to this occurrence of the problem. Like title, this field’s value can be localized", required = false, nullable = true)
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
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.id, apiError.id) &&
        Objects.equals(this.status, apiError.status) &&
        Objects.equals(this.code, apiError.code) &&
        Objects.equals(this.title, apiError.title) &&
        Objects.equals(this.detail, apiError.detail);
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

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

