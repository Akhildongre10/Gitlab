package com.armory.WeaponVault.organizationApi;

import com.armory.WeaponVault.entityDTO.CategoryDto;
import com.armory.WeaponVault.entityDTO.CategoryDtoInsert;
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
 * A delegate to be called by the {@link CategoryApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-30T17:45:15.281186947+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public interface CategoryApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /category : Create a new category
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param categoryDtoInsert  (required)
     * @return Category created successfully (status code 201)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Category with the same name already exists (status code 409)
     *         or Internal server error (status code 500)
     * @see CategoryApi#createCategory
     */
    default ResponseEntity<CategoryDtoInsert> createCategory(String xTenantID,
        CategoryDtoInsert categoryDtoInsert) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"manufacturerIds\" : [ 1, 2, 3 ], \"categoryName\" : \"categoryName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /category/{categoryId} : Delete category by ID
     *
     * @param categoryId ID of the category to delete (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Category deleted successfully (status code 200)
     *         or Category not found (status code 404)
     *         or Internal server error (status code 500)
     * @see CategoryApi#deleteCategory
     */
    default ResponseEntity<Void> deleteCategory(Long categoryId,
        String xTenantID) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /category : Get all categories
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return A list of categories (status code 200)
     *         or Internal server error (status code 500)
     * @see CategoryApi#getAllCategories
     */
    default ResponseEntity<List<CategoryDto>> getAllCategories(String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /category/{categoryId} : Get category by ID
     *
     * @param categoryId ID of the category to fetch (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Category details by ID (status code 200)
     *         or Category not found (status code 404)
     *         or Internal server error (status code 500)
     * @see CategoryApi#getCategoryById
     */
    default ResponseEntity<CategoryDto> getCategoryById(Long categoryId,
        String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"manufacturers\" : [ null, null ], \"inventories\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"inventoryId\" : 1, \"inventoryDetails\" : { \"model\" : \"AQW\", \"assetItemNumber\" : \"AS123\", \"site\" : \"site1\", \"nfa_category\" : \"Rifle\", \"description\" : \"Brand new rifle, fully assembled and tested.\" }, \"serialNo\" : \"serialNo\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"categoryName\" : \"categoryName\", \"categoryId\" : 6, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /category/{categoryId} : Update category by ID
     *
     * @param categoryId ID of the category to update (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param categoryDtoInsert  (required)
     * @return Category updated successfully (status code 200)
     *         or Category not found (status code 404)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Internal server error (status code 500)
     * @see CategoryApi#updateCategory
     */
    default ResponseEntity<CategoryDtoInsert> updateCategory(Long categoryId,
        String xTenantID,
        CategoryDtoInsert categoryDtoInsert) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"categoryDetails\" : { \"model\" : \"AR-15\", \"type\" : \"Rifle\", \"required_training\" : \"Basic\", \"required_qualification\" : \"Marksman\", \"caliber\" : \"5.56mm\", \"length\" : \"36 inches\", \"inspection_months\" : \"12\", \"maintenance_months\" : \"6\", \"description\" : \"A standard assault rifle.\" }, \"manufacturerIds\" : [ 1, 2, 3 ], \"categoryName\" : \"categoryName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
