package com.toda.todo.model.dto.generated;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FormError
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-03T04:48:05.260449800+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
public class FormError implements Serializable {

  private static final long serialVersionUID = 1L;

  private String attrName;

  private String code;

  public FormError attrName(String attrName) {
    this.attrName = attrName;
    return this;
  }

  /**
   * Get attrName
   * @return attrName
   */
  
  @JsonProperty("attrName")
  public String getAttrName() {
    return attrName;
  }

  public void setAttrName(String attrName) {
    this.attrName = attrName;
  }

  public FormError code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormError formError = (FormError) o;
    return Objects.equals(this.attrName, formError.attrName) &&
        Objects.equals(this.code, formError.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attrName, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormError {\n");
    sb.append("    attrName: ").append(toIndentedString(attrName)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

