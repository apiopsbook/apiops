package com.acmepetsupplies.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * contains references to the source of the error
 */

@Schema(name = "Error_errors_inner_source", description = "contains references to the source of the error")
@JsonTypeName("Error_errors_inner_source")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-18T20:17:33.879399+01:00[Europe/London]")
public class ErrorErrorsInnerSource {

  private String pointer;

  private String parameter;

  public ErrorErrorsInnerSource pointer(String pointer) {
    this.pointer = pointer;
    return this;
  }

  /**
   * a JSON Pointer [RFC6901] to the associated entity in the request document
   * @return pointer
  */
  @Size(max = 500) 
  @Schema(name = "pointer", description = "a JSON Pointer [RFC6901] to the associated entity in the request document", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pointer")
  public String getPointer() {
    return pointer;
  }

  public void setPointer(String pointer) {
    this.pointer = pointer;
  }

  public ErrorErrorsInnerSource parameter(String parameter) {
    this.parameter = parameter;
    return this;
  }

  /**
   * indicates which URI query parameter caused the error
   * @return parameter
  */
  @Size(max = 50) 
  @Schema(name = "parameter", description = "indicates which URI query parameter caused the error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parameter")
  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorErrorsInnerSource errorErrorsInnerSource = (ErrorErrorsInnerSource) o;
    return Objects.equals(this.pointer, errorErrorsInnerSource.pointer) &&
        Objects.equals(this.parameter, errorErrorsInnerSource.parameter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pointer, parameter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorErrorsInnerSource {\n");
    sb.append("    pointer: ").append(toIndentedString(pointer)).append("\n");
    sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
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

