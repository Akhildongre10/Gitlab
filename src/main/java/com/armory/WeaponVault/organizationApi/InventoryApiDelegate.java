package com.armory.WeaponVault.organizationApi;

import com.armory.WeaponVault.entityDTO.InventoryDto;
import com.armory.WeaponVault.entityDTO.InventoryDtoId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link InventoryApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-29T14:12:51.910033071+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public interface InventoryApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /inventory : Create a new inventory
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param inventoryDtoId  (required)
     * @return Inventory created successfully (status code 201)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Inventory with same serial no is already present. (status code 409)
     *         or Internal server error (status code 500)
     * @see InventoryApi#createInventory
     */
    default ResponseEntity<InventoryDto> createInventory(String xTenantID,
        InventoryDtoId inventoryDtoId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /inventory/{inventoryId} : Delete inventory by inventoryId
     *
     * @param inventoryId ID of the inventory to delete (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Inventory deleted successfully (status code 200)
     *         or Inventory not found (status code 404)
     *         or Internal server error (status code 500)
     * @see InventoryApi#deleteInventory
     */
    default ResponseEntity<Void> deleteInventory(Long inventoryId,
        String xTenantID) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /inventory : Get all inventories
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return A list of Inventories (status code 200)
     *         or Internal server error (status code 500)
     * @see InventoryApi#getAllInventories
     */
    default ResponseEntity<List<InventoryDto>> getAllInventories(String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /inventory/category/{categoryId} : Get inventories by categoryId
     *
     * @param categoryId Category ID to fetch associated inventories (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return List of inventories for the specified category ID (status code 200)
     *         or No inventory found for the category (status code 404)
     *         or Internal server error (status code 500)
     * @see InventoryApi#getInventoriesByCategoryId
     */
    default ResponseEntity<List<InventoryDto>> getInventoriesByCategoryId(Long categoryId,
        String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /inventory/{inventoryId} : Get inventory by inventoryId
     *
     * @param inventoryId ID of the inventory to fetch (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Inventory details by inventoryId (status code 200)
     *         or Inventory not found (status code 404)
     *         or Internal server error (status code 500)
     * @see InventoryApi#getInventoryById
     */
    default ResponseEntity<InventoryDto> getInventoryById(Long inventoryId,
        String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /inventory/serial/{serialNo} : Get inventory by serial number
     *
     * @param serialNo Serial number of the inventory to fetch (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Inventory details by serial number (status code 200)
     *         or Inventory not found (status code 404)
     *         or Internal server error (status code 500)
     * @see InventoryApi#getInventoryBySerialNo
     */
    default ResponseEntity<InventoryDto> getInventoryBySerialNo(String serialNo,
        String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /inventory/{inventoryId} : Update inventory by inventoryId
     *
     * @param inventoryId ID of the inventory to update (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param inventoryDtoId  (required)
     * @return Inventory updated successfully (status code 200)
     *         or Inventory data not found (status code 404)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Internal server error (status code 500)
     * @see InventoryApi#updateInventory
     */
    default ResponseEntity<InventoryDto> updateInventory(Long inventoryId,
        String xTenantID,
        InventoryDtoId inventoryDtoId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
