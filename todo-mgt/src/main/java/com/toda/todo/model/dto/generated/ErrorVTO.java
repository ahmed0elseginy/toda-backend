package com.toda.todo.model.dto.generated;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.toda.todo.model.dto.generated.FormError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ErrorVTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-03T04:48:05.260449800+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
public class ErrorVTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String domain;

  private String code;

  private String message;

  @Valid
  private List<@Valid FormError> formErrors = new ArrayList<>();

  public ErrorVTO domain(String domain) {
    this.domain = domain;
    return this;
  }

  /**
   * Get domain
   * @return domain
   */
  
  @JsonProperty("domain")
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public ErrorVTO code(String code) {
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

  public ErrorVTO message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorVTO formErrors(List<@Valid FormError> formErrors) {
    this.formErrors = formErrors;
    return this;
  }

  public ErrorVTO addFormErrorsItem(FormError formErrorsItem) {
    if (this.formErrors == null) {
      this.formErrors = new ArrayList<>();
    }
    this.formErrors.add(formErrorsItem);
    return this;
  }

  /**
   * Get formErrors
   * @return formErrors
   */
  @Valid 
  @JsonProperty("formErrors")
  public List<@Valid FormError> getFormErrors() {
    return formErrors;
  }

  public void setFormErrors(List<@Valid FormError> formErrors) {
    this.formErrors = formErrors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorVTO errorVTO = (ErrorVTO) o;
    return Objects.equals(this.domain, errorVTO.domain) &&
        Objects.equals(this.code, errorVTO.code) &&
        Objects.equals(this.message, errorVTO.message) &&
        Objects.equals(this.formErrors, errorVTO.formErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domain, code, message, formErrors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorVTO {\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    formErrors: ").append(toIndentedString(formErrors)).append("\n");
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

