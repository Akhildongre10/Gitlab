package com.armory.WeaponVault.organizationApi;

import com.armory.WeaponVault.entityDTO.ManufacturerDto;
import com.armory.WeaponVault.entityDTO.ManufacturerDtoInsert;
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
 * A delegate to be called by the {@link ManufacturerApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-30T17:45:15.281186947+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public interface ManufacturerApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /manufacturer : Create a new manufacturer
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param manufacturerDtoInsert  (required)
     * @return Manufacturer created successfully (status code 201)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Organization with same name already present. (status code 409)
     *         or Internal server error (status code 500)
     * @see ManufacturerApi#createManufacturer
     */
    default ResponseEntity<ManufacturerDtoInsert> createManufacturer(String xTenantID,
        ManufacturerDtoInsert manufacturerDtoInsert) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /manufacturer/{manufacturerId} : Delete manufacturer by manufacturerId
     *
     * @param manufacturerId ID of the manufacturer to delete (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Manufacturer deleted successfully (status code 200)
     *         or Manufacturer not found (status code 404)
     *         or Internal server error (status code 500)
     * @see ManufacturerApi#deleteManufacturer
     */
    default ResponseEntity<Void> deleteManufacturer(Long manufacturerId,
        String xTenantID) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /manufacturer : Get all manufacturers
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return A list of manufacturers (status code 200)
     *         or Internal server error (status code 500)
     * @see ManufacturerApi#getAllManufacturers
     */
    default ResponseEntity<List<ManufacturerDto>> getAllManufacturers(String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"id\" : 0, \"categories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"status\" : \"status\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"id\" : 0, \"categories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"status\" : \"status\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /manufacturer/{manufacturerId} : Get manufacturer by manufacturerId
     *
     * @param manufacturerId ID of the manufacturer to fetch (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Manufacturer details by manufacturerId (status code 200)
     *         or Manufacturer not found (status code 404)
     *         or Internal server error (status code 500)
     * @see ManufacturerApi#getManufacturerById
     */
    default ResponseEntity<ManufacturerDto> getManufacturerById(Long manufacturerId,
        String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"name\", \"id\" : 0, \"categories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"status\" : \"status\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /manufacturer/{manufacturerId} : Update manufacturer by manufacturerId
     *
     * @param manufacturerId ID of the manufacturer to update (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param manufacturerDtoInsert  (required)
     * @return Manufacturer updated successfully (status code 200)
     *         or Manufacturer not found (status code 404)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Internal server error (status code 500)
     * @see ManufacturerApi#updateManufacturer
     */
    default ResponseEntity<ManufacturerDtoInsert> updateManufacturer(Long manufacturerId,
        String xTenantID,
        ManufacturerDtoInsert manufacturerDtoInsert) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
