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
 * SuperAdminSuccessResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-01T14:23:20.376969458+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class SuperAdminSuccessResponse implements SuperAdminResponse {

  private @Nullable String token;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime tokenExpiry;

  private @Nullable String role;

  private @Nullable Long id;

  private @Nullable String email;

  private @Nullable String name;

  private @Nullable String phoneNumber;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime updatedAt;

  public SuperAdminSuccessResponse token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   */
  
  @Schema(name = "token", example = "***..", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public SuperAdminSuccessResponse tokenExpiry(LocalDateTime tokenExpiry) {
    this.tokenExpiry = tokenExpiry;
    return this;
  }

  /**
   * The timestamp when the SuperAdmin was created.
   * @return tokenExpiry
   */
  @Valid 
  @Schema(name = "tokenExpiry", description = "The timestamp when the SuperAdmin was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tokenExpiry")
  public LocalDateTime getTokenExpiry() {
    return tokenExpiry;
  }

  public void setTokenExpiry(LocalDateTime tokenExpiry) {
    this.tokenExpiry = tokenExpiry;
  }

  public SuperAdminSuccessResponse role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   */
  
  @Schema(name = "role", example = "role", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public SuperAdminSuccessResponse id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the SuperAdmin.
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of the SuperAdmin.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SuperAdminSuccessResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  
  @Schema(name = "email", example = "email@example.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SuperAdminSuccessResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", example = "John Doe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SuperAdminSuccessResponse phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
   */
  
  @Schema(name = "phoneNumber", example = "+1234567890", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public SuperAdminSuccessResponse createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The timestamp when the SuperAdmin was created.
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", description = "The timestamp when the SuperAdmin was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public SuperAdminSuccessResponse updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The timestamp when the SuperAdmin was last updated.
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", description = "The timestamp when the SuperAdmin was last updated.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    SuperAdminSuccessResponse superAdminSuccessResponse = (SuperAdminSuccessResponse) o;
    return Objects.equals(this.token, superAdminSuccessResponse.token) &&
        Objects.equals(this.tokenExpiry, superAdminSuccessResponse.tokenExpiry) &&
        Objects.equals(this.role, superAdminSuccessResponse.role) &&
        Objects.equals(this.id, superAdminSuccessResponse.id) &&
        Objects.equals(this.email, superAdminSuccessResponse.email) &&
        Objects.equals(this.name, superAdminSuccessResponse.name) &&
        Objects.equals(this.phoneNumber, superAdminSuccessResponse.phoneNumber) &&
        Objects.equals(this.createdAt, superAdminSuccessResponse.createdAt) &&
        Objects.equals(this.updatedAt, superAdminSuccessResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, tokenExpiry, role, id, email, name, phoneNumber, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuperAdminSuccessResponse {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    tokenExpiry: ").append(toIndentedString(tokenExpiry)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
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

