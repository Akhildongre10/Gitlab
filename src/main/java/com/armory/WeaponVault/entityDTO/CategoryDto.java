package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.armory.WeaponVault.entityDTO.InventoryDto;
import com.armory.WeaponVault.entityDTO.ManufacturerDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
 * CategoryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-01T14:23:20.376969458+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class CategoryDto {

  private @Nullable Long categoryId;

  @Valid
  private List<@Valid ManufacturerDto> manufacturers = new ArrayList<>();

  private String categoryName;

  @Valid
  private Map<String, Object> categoryDetails = new HashMap<>();

  @Valid
  private List<@Valid InventoryDto> inventories = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime updatedAt;

  public CategoryDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategoryDto(String categoryName, Map<String, Object> categoryDetails) {
    this.categoryName = categoryName;
    this.categoryDetails = categoryDetails;
  }

  public CategoryDto categoryId(Long categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * The unique identifier for the category.
   * @return categoryId
   */
  
  @Schema(name = "categoryId", description = "The unique identifier for the category.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoryId")
  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public CategoryDto manufacturers(List<@Valid ManufacturerDto> manufacturers) {
    this.manufacturers = manufacturers;
    return this;
  }

  public CategoryDto addManufacturersItem(ManufacturerDto manufacturersItem) {
    if (this.manufacturers == null) {
      this.manufacturers = new ArrayList<>();
    }
    this.manufacturers.add(manufacturersItem);
    return this;
  }

  /**
   * List of manufacturers associated with the category.
   * @return manufacturers
   */
  @Valid 
  @Schema(name = "manufacturers", description = "List of manufacturers associated with the category.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("manufacturers")
  public List<@Valid ManufacturerDto> getManufacturers() {
    return manufacturers;
  }

  public void setManufacturers(List<@Valid ManufacturerDto> manufacturers) {
    this.manufacturers = manufacturers;
  }

  public CategoryDto categoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  /**
   * The name of the category.
   * @return categoryName
   */
  @NotNull 
  @Schema(name = "categoryName", description = "The name of the category.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("categoryName")
  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public CategoryDto categoryDetails(Map<String, Object> categoryDetails) {
    this.categoryDetails = categoryDetails;
    return this;
  }

  public CategoryDto putCategoryDetailsItem(String key, Object categoryDetailsItem) {
    if (this.categoryDetails == null) {
      this.categoryDetails = new HashMap<>();
    }
    this.categoryDetails.put(key, categoryDetailsItem);
    return this;
  }

  /**
   * A JSON object containing various details about the category (e.g., model, type, etc.).
   * @return categoryDetails
   */
  @NotNull 
  @Schema(name = "categoryDetails", example = "{\"model\":\"AR-15\",\"type\":\"Rifle\",\"required_training\":\"Basic\",\"required_qualification\":\"Marksman\",\"caliber\":\"5.56mm\",\"length\":\"36 inches\",\"inspection_months\":\"12\",\"maintenance_months\":\"6\",\"description\":\"A standard assault rifle.\"}", description = "A JSON object containing various details about the category (e.g., model, type, etc.).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("categoryDetails")
  public Map<String, Object> getCategoryDetails() {
    return categoryDetails;
  }

  public void setCategoryDetails(Map<String, Object> categoryDetails) {
    this.categoryDetails = categoryDetails;
  }

  public CategoryDto inventories(List<@Valid InventoryDto> inventories) {
    this.inventories = inventories;
    return this;
  }

  public CategoryDto addInventoriesItem(InventoryDto inventoriesItem) {
    if (this.inventories == null) {
      this.inventories = new ArrayList<>();
    }
    this.inventories.add(inventoriesItem);
    return this;
  }

  /**
   * List of inventories associated with the category.
   * @return inventories
   */
  @Valid 
  @Schema(name = "inventories", description = "List of inventories associated with the category.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("inventories")
  public List<@Valid InventoryDto> getInventories() {
    return inventories;
  }

  public void setInventories(List<@Valid InventoryDto> inventories) {
    this.inventories = inventories;
  }

  public CategoryDto createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The timestamp when the category was created.
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", description = "The timestamp when the category was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public CategoryDto updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The timestamp when the category was last updated.
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", description = "The timestamp when the category was last updated.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    CategoryDto categoryDto = (CategoryDto) o;
    return Objects.equals(this.categoryId, categoryDto.categoryId) &&
        Objects.equals(this.manufacturers, categoryDto.manufacturers) &&
        Objects.equals(this.categoryName, categoryDto.categoryName) &&
        Objects.equals(this.categoryDetails, categoryDto.categoryDetails) &&
        Objects.equals(this.inventories, categoryDto.inventories) &&
        Objects.equals(this.createdAt, categoryDto.createdAt) &&
        Objects.equals(this.updatedAt, categoryDto.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, manufacturers, categoryName, categoryDetails, inventories, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDto {\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    manufacturers: ").append(toIndentedString(manufacturers)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
    sb.append("    categoryDetails: ").append(toIndentedString(categoryDetails)).append("\n");
    sb.append("    inventories: ").append(toIndentedString(inventories)).append("\n");
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

