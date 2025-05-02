package com.toda.user.model.dto.generated;

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
 * UserProfileDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-02T05:18:29.793393200+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
public class UserProfileDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String firstName;

  private String lastName;

  private String mobileNumber;

  public UserProfileDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserProfileDTO(String firstName, String lastName, String mobileNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.mobileNumber = mobileNumber;
  }

  public UserProfileDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   */
  @NotNull @Size(min = 2, max = 25) 
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserProfileDTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   */
  @NotNull @Size(min = 2, max = 25) 
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserProfileDTO mobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * @return mobileNumber
   */
  @NotNull 
  @JsonProperty("mobileNumber")
  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfileDTO userProfileDTO = (UserProfileDTO) o;
    return Objects.equals(this.firstName, userProfileDTO.firstName) &&
        Objects.equals(this.lastName, userProfileDTO.lastName) &&
        Objects.equals(this.mobileNumber, userProfileDTO.mobileNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, mobileNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserProfileDTO {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
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

