package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.armory.WeaponVault.entityDTO.CategoryDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * ManufacturerDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-29T14:12:51.910033071+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class ManufacturerDto {

  private @Nullable Long id;

  private String name;

  private @Nullable String status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime updatedAt;

  @Valid
  private List<@Valid CategoryDto> categories = new ArrayList<>();

  public ManufacturerDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ManufacturerDto(String name) {
    this.name = name;
  }

  public ManufacturerDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the manufacturer
   * @return id
   */
  
  @Schema(name = "id", description = "Unique identifier for the manufacturer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ManufacturerDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the manufacturer
   * @return name
   */
  @NotNull 
  @Schema(name = "name", description = "Name of the manufacturer", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ManufacturerDto status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the manufacturer (e.g., active, inactive)
   * @return status
   */
  
  @Schema(name = "status", description = "Status of the manufacturer (e.g., active, inactive)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ManufacturerDto createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Timestamp when the manufacturer was created
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", description = "Timestamp when the manufacturer was created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ManufacturerDto updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Timestamp when the manufacturer was last updated
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", description = "Timestamp when the manufacturer was last updated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public ManufacturerDto categories(List<@Valid CategoryDto> categories) {
    this.categories = categories;
    return this;
  }

  public ManufacturerDto addCategoriesItem(CategoryDto categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * List of categories associated with the manufacturer.
   * @return categories
   */
  @Valid 
  @Schema(name = "categories", description = "List of categories associated with the manufacturer.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categories")
  public List<@Valid CategoryDto> getCategories() {
    return categories;
  }

  public void setCategories(List<@Valid CategoryDto> categories) {
    this.categories = categories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManufacturerDto manufacturerDto = (ManufacturerDto) o;
    return Objects.equals(this.id, manufacturerDto.id) &&
        Objects.equals(this.name, manufacturerDto.name) &&
        Objects.equals(this.status, manufacturerDto.status) &&
        Objects.equals(this.createdAt, manufacturerDto.createdAt) &&
        Objects.equals(this.updatedAt, manufacturerDto.updatedAt) &&
        Objects.equals(this.categories, manufacturerDto.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, createdAt, updatedAt, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManufacturerDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
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

