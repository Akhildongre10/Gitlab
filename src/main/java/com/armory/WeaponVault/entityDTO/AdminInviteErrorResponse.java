package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdminInviteErrorResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-01T14:23:19.910106306+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class AdminInviteErrorResponse implements AdminInviteResponse {

  private String error;

  public AdminInviteErrorResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AdminInviteErrorResponse(String error) {
    this.error = error;
  }

  public AdminInviteErrorResponse error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   */
  @NotNull 
  @Schema(name = "error", example = "Error message here", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("error")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminInviteErrorResponse adminInviteErrorResponse = (AdminInviteErrorResponse) o;
    return Objects.equals(this.error, adminInviteErrorResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminInviteErrorResponse {\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

