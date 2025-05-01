package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DepartmentDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-01T14:23:20.376969458+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class DepartmentDto {

  private @Nullable Long departmentId;

  private String departmentName;

  @Valid
  private Map<String, Object> departmentDetails = new HashMap<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime updatedAt;

  public DepartmentDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DepartmentDto(String departmentName, Map<String, Object> departmentDetails) {
    this.departmentName = departmentName;
    this.departmentDetails = departmentDetails;
  }

  public DepartmentDto departmentId(Long departmentId) {
    this.departmentId = departmentId;
    return this;
  }

  /**
   * The unique identifier of the department.
   * @return departmentId
   */
  
  @Schema(name = "departmentId", description = "The unique identifier of the department.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("departmentId")
  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public DepartmentDto departmentName(String departmentName) {
    this.departmentName = departmentName;
    return this;
  }

  /**
   * The name of the department.
   * @return departmentName
   */
  @NotNull 
  @Schema(name = "departmentName", description = "The name of the department.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("departmentName")
  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public DepartmentDto departmentDetails(Map<String, Object> departmentDetails) {
    this.departmentDetails = departmentDetails;
    return this;
  }

  public DepartmentDto putDepartmentDetailsItem(String key, Object departmentDetailsItem) {
    if (this.departmentDetails == null) {
      this.departmentDetails = new HashMap<>();
    }
    this.departmentDetails.put(key, departmentDetailsItem);
    return this;
  }

  /**
   * A JSON object containing details about the department.
   * @return departmentDetails
   */
  @NotNull 
  @Schema(name = "departmentDetails", example = "{\"department_code\":\"HR001\",\"department_head\":\"John Doe\",\"description\":\"Handles all human resources tasks.\"}", description = "A JSON object containing details about the department.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("departmentDetails")
  public Map<String, Object> getDepartmentDetails() {
    return departmentDetails;
  }

  public void setDepartmentDetails(Map<String, Object> departmentDetails) {
    this.departmentDetails = departmentDetails;
  }

  public DepartmentDto createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The timestamp when the department was created.
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", description = "The timestamp when the department was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public DepartmentDto updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The timestamp when the department was last updated.
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", description = "The timestamp when the department was last updated.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DepartmentDto departmentDto = (DepartmentDto) o;
    return Objects.equals(this.departmentId, departmentDto.departmentId) &&
        Objects.equals(this.departmentName, departmentDto.departmentName) &&
        Objects.equals(this.departmentDetails, departmentDto.departmentDetails) &&
        Objects.equals(this.createdAt, departmentDto.createdAt) &&
        Objects.equals(this.updatedAt, departmentDto.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(departmentId, departmentName, departmentDetails, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepartmentDto {\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    departmentName: ").append(toIndentedString(departmentName)).append("\n");
    sb.append("    departmentDetails: ").append(toIndentedString(departmentDetails)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

