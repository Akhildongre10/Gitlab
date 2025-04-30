package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategoryDtoInsert
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-30T17:45:15.281186947+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class CategoryDtoInsert {

  private String categoryName;

  @Valid
  private Map<String, Object> categoryDetails = new HashMap<>();

  @Valid
  private List<Long> manufacturerIds = new ArrayList<>();

  public CategoryDtoInsert() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategoryDtoInsert(String categoryName, Map<String, Object> categoryDetails, List<Long> manufacturerIds) {
    this.categoryName = categoryName;
    this.categoryDetails = categoryDetails;
    this.manufacturerIds = manufacturerIds;
  }

  public CategoryDtoInsert categoryName(String categoryName) {
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

  public CategoryDtoInsert categoryDetails(Map<String, Object> categoryDetails) {
    this.categoryDetails = categoryDetails;
    return this;
  }

  public CategoryDtoInsert putCategoryDetailsItem(String key, Object categoryDetailsItem) {
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

  public CategoryDtoInsert manufacturerIds(List<Long> manufacturerIds) {
    this.manufacturerIds = manufacturerIds;
    return this;
  }

  public CategoryDtoInsert addManufacturerIdsItem(Long manufacturerIdsItem) {
    if (this.manufacturerIds == null) {
      this.manufacturerIds = new ArrayList<>();
    }
    this.manufacturerIds.add(manufacturerIdsItem);
    return this;
  }

  /**
   * Get manufacturerIds
   * @return manufacturerIds
   */
  @NotNull 
  @Schema(name = "manufacturerIds", example = "[1,2,3]", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("manufacturerIds")
  public List<Long> getManufacturerIds() {
    return manufacturerIds;
  }

  public void setManufacturerIds(List<Long> manufacturerIds) {
    this.manufacturerIds = manufacturerIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryDtoInsert categoryDtoInsert = (CategoryDtoInsert) o;
    return Objects.equals(this.categoryName, categoryDtoInsert.categoryName) &&
        Objects.equals(this.categoryDetails, categoryDtoInsert.categoryDetails) &&
        Objects.equals(this.manufacturerIds, categoryDtoInsert.manufacturerIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryName, categoryDetails, manufacturerIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDtoInsert {\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
    sb.append("    categoryDetails: ").append(toIndentedString(categoryDetails)).append("\n");
    sb.append("    manufacturerIds: ").append(toIndentedString(manufacturerIds)).append("\n");
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

