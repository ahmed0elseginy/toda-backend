package com.toda.todo.model.dto.generated;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.toda.todo.model.dto.generated.TodoVTO;
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
 * TodoResultSet
 */
@lombok.Data
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-11T11:39:50.362109300+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
public class TodoResultSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  private List<@Valid TodoVTO> data = new ArrayList<>();

  private Integer pageNum;

  private Integer pageSize;

  private Long total;

}

