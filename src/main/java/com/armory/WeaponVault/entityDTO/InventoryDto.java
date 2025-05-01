package com.armory.WeaponVault.entityDTO;

import java.net.URI;
import java.util.Objects;
import com.armory.WeaponVault.entityDTO.CategoryDto;
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
 * InventoryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-01T14:23:20.376969458+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public class InventoryDto {

  private @Nullable Long inventoryId;

  private @Nullable CategoryDto category;

  private String serialNo;

  @Valid
  private Map<String, Object> inventoryDetails = new HashMap<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable LocalDateTime updatedAt;

  public InventoryDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InventoryDto(String serialNo) {
    this.serialNo = serialNo;
  }

  public InventoryDto inventoryId(Long inventoryId) {
    this.inventoryId = inventoryId;
    return this;
  }

  /**
   * The unique identifier for the inventory item.
   * @return inventoryId
   */
  
  @Schema(name = "inventoryId", description = "The unique identifier for the inventory item.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("inventoryId")
  public Long getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(Long inventoryId) {
    this.inventoryId = inventoryId;
  }

  public InventoryDto category(CategoryDto category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   */
  @Valid 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public CategoryDto getCategory() {
    return category;
  }

  public void setCategory(CategoryDto category) {
    this.category = category;
  }

  public InventoryDto serialNo(String serialNo) {
    this.serialNo = serialNo;
    return this;
  }

  /**
   * The serial number of the inventory item.
   * @return serialNo
   */
  @NotNull 
  @Schema(name = "serialNo", description = "The serial number of the inventory item.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("serialNo")
  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public InventoryDto inventoryDetails(Map<String, Object> inventoryDetails) {
    this.inventoryDetails = inventoryDetails;
    return this;
  }

  public InventoryDto putInventoryDetailsItem(String key, Object inventoryDetailsItem) {
    if (this.inventoryDetails == null) {
      this.inventoryDetails = new HashMap<>();
    }
    this.inventoryDetails.put(key, inventoryDetailsItem);
    return this;
  }

  /**
   * A JSON object containing varisous details about the inventory item (e.g., lot number, rebuild date, etc.).
   * @return inventoryDetails
   */
  
  @Schema(name = "inventoryDetails", example = "{\"model\":\"AQW\",\"assetItemNumber\":\"AS123\",\"site\":\"site1\",\"nfa_category\":\"Rifle\",\"description\":\"Brand new rifle, fully assembled and tested.\"}", description = "A JSON object containing varisous details about the inventory item (e.g., lot number, rebuild date, etc.).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("inventoryDetails")
  public Map<String, Object> getInventoryDetails() {
    return inventoryDetails;
  }

  public void setInventoryDetails(Map<String, Object> inventoryDetails) {
    this.inventoryDetails = inventoryDetails;
  }

  public InventoryDto createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The timestamp when the inventory item was created.
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", description = "The timestamp when the inventory item was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public InventoryDto updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The timestamp when the inventory item was last updated.
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", description = "The timestamp when the inventory item was last updated.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    InventoryDto inventoryDto = (InventoryDto) o;
    return Objects.equals(this.inventoryId, inventoryDto.inventoryId) &&
        Objects.equals(this.category, inventoryDto.category) &&
        Objects.equals(this.serialNo, inventoryDto.serialNo) &&
        Objects.equals(this.inventoryDetails, inventoryDto.inventoryDetails) &&
        Objects.equals(this.createdAt, inventoryDto.createdAt) &&
        Objects.equals(this.updatedAt, inventoryDto.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inventoryId, category, serialNo, inventoryDetails, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InventoryDto {\n");
    sb.append("    inventoryId: ").append(toIndentedString(inventoryId)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    serialNo: ").append(toIndentedString(serialNo)).append("\n");
    sb.append("    inventoryDetails: ").append(toIndentedString(inventoryDetails)).append("\n");
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

