package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdminInviteRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-29T13:52:58.938669090+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class AdminInviteRequest {

  private String email;

  private String fullName;

  private Long organizationId;

  public AdminInviteRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AdminInviteRequest(String email, String fullName, Long organizationId) {
    this.email = email;
    this.fullName = fullName;
    this.organizationId = organizationId;
  }

  public AdminInviteRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email address of the invited admin.
   * @return email
   */
  @NotNull 
  @Schema(name = "email", description = "The email address of the invited admin.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AdminInviteRequest fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * The full name of the invited admin.
   * @return fullName
   */
  @NotNull 
  @Schema(name = "fullName", description = "The full name of the invited admin.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public AdminInviteRequest organizationId(Long organizationId) {
    this.organizationId = organizationId;
    return this;
  }

  /**
   * The organization Id.
   * @return organizationId
   */
  @NotNull 
  @Schema(name = "organizationId", description = "The organization Id.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organizationId")
  public Long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminInviteRequest adminInviteRequest = (AdminInviteRequest) o;
    return Objects.equals(this.email, adminInviteRequest.email) &&
        Objects.equals(this.fullName, adminInviteRequest.fullName) &&
        Objects.equals(this.organizationId, adminInviteRequest.organizationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, fullName, organizationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminInviteRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
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

