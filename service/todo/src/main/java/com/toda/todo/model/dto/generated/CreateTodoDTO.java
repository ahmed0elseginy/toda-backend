package com.toda.todo.model.dto.generated;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.toda.todo.model.dto.generated.Priority;
import com.toda.todo.model.dto.generated.Status;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateTodoDTO
 */
@lombok.Data
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-11T11:39:50.362109300+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
public class CreateTodoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String title;

  private Long userId;

  private String description;

  private Priority priority;

  private Status status;

}

