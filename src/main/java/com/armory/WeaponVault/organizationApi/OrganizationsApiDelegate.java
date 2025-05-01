package com.armory.WeaponVault.organizationApi;

import com.armory.WeaponVault.entityDTO.GetAllOrganizations403Response;
import com.armory.WeaponVault.entityDTO.GetAllOrganizations500Response;
import com.armory.WeaponVault.entityDTO.GetOrganizationById404Response;
import com.armory.WeaponVault.entityDTO.OrganizationDto;
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
 * A delegate to be called by the {@link OrganizationsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-01T14:23:20.376969458+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public interface OrganizationsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /organizations : Create a new organization
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param organizationDto  (required)
     * @return Organization created successfully (status code 201)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Forbidden - Access Denied (status code 403)
     *         or Organization with same name already present. (status code 409)
     *         or Internal server error (status code 500)
     * @see OrganizationsApi#createOrganization
     */
    default ResponseEntity<OrganizationDto> createOrganization(String xTenantID,
        OrganizationDto organizationDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"organizationId\" : 0, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"organizationName\" : \"organizationName\", \"organizationDetails\" : { \"email\" : \"admin@weaponvault.com\", \"phone_no\" : \"+1234567890\" }, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Forbidden\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Internal server error\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /organizations/{organizationId} : Delete Organization by organizationId
     *
     * @param organizationId ID of the organization to delete (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Organization deleted successfully (status code 200)
     *         or Forbidden - Access Denied (status code 403)
     *         or Organization not found (status code 404)
     *         or Internal server error (status code 500)
     * @see OrganizationsApi#deleteOrganization
     */
    default ResponseEntity<Void> deleteOrganization(Long organizationId,
        String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Forbidden\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Organization not found\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /organizations : Get all organizations
     *
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return A list of Organizations (status code 200)
     *         or Forbidden - Access Denied (status code 403)
     *         or Internal server error (status code 500)
     * @see OrganizationsApi#getAllOrganizations
     */
    default ResponseEntity<List<OrganizationDto>> getAllOrganizations(String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"organizationId\" : 0, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"organizationName\" : \"organizationName\", \"organizationDetails\" : { \"email\" : \"admin@weaponvault.com\", \"phone_no\" : \"+1234567890\" }, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"status\" }, { \"organizationId\" : 0, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"organizationName\" : \"organizationName\", \"organizationDetails\" : { \"email\" : \"admin@weaponvault.com\", \"phone_no\" : \"+1234567890\" }, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"status\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Forbidden\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Internal server error\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /organizations/{organizationId} : Get organization by organizationId
     *
     * @param organizationId ID of the organization to fetch (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @return Organization details by organizationId (status code 200)
     *         or Forbidden - Access Denied (status code 403)
     *         or Organization not found (status code 404)
     *         or Internal server error (status code 500)
     * @see OrganizationsApi#getOrganizationById
     */
    default ResponseEntity<OrganizationDto> getOrganizationById(Long organizationId,
        String xTenantID) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"organizationId\" : 0, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"organizationName\" : \"organizationName\", \"organizationDetails\" : { \"email\" : \"admin@weaponvault.com\", \"phone_no\" : \"+1234567890\" }, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Forbidden\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Organization not found\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /organizations/{organizationId} : Update organization by organization Id
     *
     * @param organizationId ID of the organization to update (required)
     * @param xTenantID Tenant identifier for multi-tenancy. (required)
     * @param organizationDto  (required)
     * @return Organization updated successfully (status code 200)
     *         or Forbidden - Access Denied (status code 403)
     *         or Organization data not found (status code 404)
     *         or Bad request - Missing or invalid data (status code 400)
     *         or Internal server error (status code 500)
     * @see OrganizationsApi#updateOrganization
     */
    default ResponseEntity<OrganizationDto> updateOrganization(Long organizationId,
        String xTenantID,
        OrganizationDto organizationDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"organizationId\" : 0, \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"organizationName\" : \"organizationName\", \"organizationDetails\" : { \"email\" : \"admin@weaponvault.com\", \"phone_no\" : \"+1234567890\" }, \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"status\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Forbidden\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"error\" : \"Organization not found\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
