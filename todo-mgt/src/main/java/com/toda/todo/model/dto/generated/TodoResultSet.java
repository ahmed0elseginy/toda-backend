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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-03T04:48:05.260449800+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
public class TodoResultSet implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  private List<@Valid TodoVTO> data = new ArrayList<>();

  private Integer pageNum;

  private Integer pageSize;

  private Long total;

  public TodoResultSet data(List<@Valid TodoVTO> data) {
    this.data = data;
    return this;
  }

  public TodoResultSet addDataItem(TodoVTO dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @Valid 
  @JsonProperty("data")
  public List<@Valid TodoVTO> getData() {
    return data;
  }

  public void setData(List<@Valid TodoVTO> data) {
    this.data = data;
  }

  public TodoResultSet pageNum(Integer pageNum) {
    this.pageNum = pageNum;
    return this;
  }

  /**
   * Get pageNum
   * @return pageNum
   */
  
  @JsonProperty("pageNum")
  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public TodoResultSet pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Get pageSize
   * @return pageSize
   */
  
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public TodoResultSet total(Long total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
   */
  
  @JsonProperty("total")
  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodoResultSet todoResultSet = (TodoResultSet) o;
    return Objects.equals(this.data, todoResultSet.data) &&
        Objects.equals(this.pageNum, todoResultSet.pageNum) &&
        Objects.equals(this.pageSize, todoResultSet.pageSize) &&
        Objects.equals(this.total, todoResultSet.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, pageNum, pageSize, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodoResultSet {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    pageNum: ").append(toIndentedString(pageNum)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

