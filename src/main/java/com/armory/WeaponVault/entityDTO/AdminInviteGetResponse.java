package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
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
 * AdminInviteGetResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-29T13:52:58.938669090+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class AdminInviteGetResponse implements AdminInviteResponse {

  private String email;

  private String fullName;

  private String organizationName;

  private String invitedBy;

  private String status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime expiresAt;

  public AdminInviteGetResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AdminInviteGetResponse(String email, String fullName, String organizationName, String invitedBy, String status, LocalDateTime expiresAt) {
    this.email = email;
    this.fullName = fullName;
    this.organizationName = organizationName;
    this.invitedBy = invitedBy;
    this.status = status;
    this.expiresAt = expiresAt;
  }

  public AdminInviteGetResponse email(String email) {
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

  public AdminInviteGetResponse fullName(String fullName) {
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

  public AdminInviteGetResponse organizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  /**
   * The full name of the invited admin.
   * @return organizationName
   */
  @NotNull 
  @Schema(name = "organizationName", description = "The full name of the invited admin.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organizationName")
  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public AdminInviteGetResponse invitedBy(String invitedBy) {
    this.invitedBy = invitedBy;
    return this;
  }

  /**
   * The full name of the invited admin.
   * @return invitedBy
   */
  @NotNull 
  @Schema(name = "invitedBy", description = "The full name of the invited admin.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("invitedBy")
  public String getInvitedBy() {
    return invitedBy;
  }

  public void setInvitedBy(String invitedBy) {
    this.invitedBy = invitedBy;
  }

  public AdminInviteGetResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the invited admin.
   * @return status
   */
  @NotNull 
  @Schema(name = "status", description = "The status of the invited admin.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public AdminInviteGetResponse expiresAt(LocalDateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * The timestamp when the invite will expire.
   * @return expiresAt
   */
  @NotNull @Valid 
  @Schema(name = "expiresAt", description = "The timestamp when the invite will expire.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("expiresAt")
  public LocalDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(LocalDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminInviteGetResponse adminInviteGetResponse = (AdminInviteGetResponse) o;
    return Objects.equals(this.email, adminInviteGetResponse.email) &&
        Objects.equals(this.fullName, adminInviteGetResponse.fullName) &&
        Objects.equals(this.organizationName, adminInviteGetResponse.organizationName) &&
        Objects.equals(this.invitedBy, adminInviteGetResponse.invitedBy) &&
        Objects.equals(this.status, adminInviteGetResponse.status) &&
        Objects.equals(this.expiresAt, adminInviteGetResponse.expiresAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, fullName, organizationName, invitedBy, status, expiresAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminInviteGetResponse {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
    sb.append("    invitedBy: ").append(toIndentedString(invitedBy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
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

