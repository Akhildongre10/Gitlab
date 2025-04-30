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
 * OrganizationDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-30T17:45:15.281186947+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class OrganizationDto {

  private @Nullable Long organizationId;

  private String organizationName;

  @Valid
  private Map<String, Object> organizationDetails = new HashMap<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime updatedAt;

  private @Nullable String status;

  public OrganizationDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrganizationDto(String organizationName, Map<String, Object> organizationDetails) {
    this.organizationName = organizationName;
    this.organizationDetails = organizationDetails;
  }

  public OrganizationDto organizationId(Long organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  /**
   * The unique identifier of the organization.
   * @return organizationId
   */
  
  @Schema(name = "organizationId", description = "The unique identifier of the organization.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("organizationId")
  public Long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }

  public OrganizationDto organizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  /**
   * The unique Name of the organization.
   * @return organizationName
   */
  @NotNull 
  @Schema(name = "organizationName", description = "The unique Name of the organization.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organizationName")
  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public OrganizationDto organizationDetails(Map<String, Object> organizationDetails) {
    this.organizationDetails = organizationDetails;
    return this;
  }

  public OrganizationDto putOrganizationDetailsItem(String key, Object organizationDetailsItem) {
    if (this.organizationDetails == null) {
      this.organizationDetails = new HashMap<>();
    }
    this.organizationDetails.put(key, organizationDetailsItem);
    return this;
  }

  /**
   * A JSON object containing details such as organization name, username, email, and phone number
   * @return organizationDetails
   */
  @NotNull 
  @Schema(name = "organizationDetails", example = "{\"email\":\"admin@weaponvault.com\",\"phone_no\":\"+1234567890\"}", description = "A JSON object containing details such as organization name, username, email, and phone number", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organizationDetails")
  public Map<String, Object> getOrganizationDetails() {
    return organizationDetails;
  }

  public void setOrganizationDetails(Map<String, Object> organizationDetails) {
    this.organizationDetails = organizationDetails;
  }

  public OrganizationDto createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The timestamp when the organization was created.
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", description = "The timestamp when the organization was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public OrganizationDto updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The timestamp when the organization was last updated.
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", description = "The timestamp when the organization was last updated.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public OrganizationDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the organization (active, inactive, etc.)
   * @return status
   */
  
  @Schema(name = "status", description = "The status of the organization (active, inactive, etc.)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationDto organizationDto = (OrganizationDto) o;
    return Objects.equals(this.organizationId, organizationDto.organizationId) &&
        Objects.equals(this.organizationName, organizationDto.organizationName) &&
        Objects.equals(this.organizationDetails, organizationDto.organizationDetails) &&
        Objects.equals(this.createdAt, organizationDto.createdAt) &&
        Objects.equals(this.updatedAt, organizationDto.updatedAt) &&
        Objects.equals(this.status, organizationDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizationId, organizationName, organizationDetails, createdAt, updatedAt, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationDto {\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
    sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
    sb.append("    organizationDetails: ").append(toIndentedString(organizationDetails)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

