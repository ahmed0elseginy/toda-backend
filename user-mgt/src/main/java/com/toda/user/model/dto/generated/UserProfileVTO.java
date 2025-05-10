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
 * UserProfileVTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-10T00:48:20.900242300+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
public class UserProfileVTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String firstName;

  private String lastName;

  private String mobileNumber;

  private String email;

}

