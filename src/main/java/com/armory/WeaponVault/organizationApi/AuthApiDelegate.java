package com.armory.WeaponVault.organizationApi;

import com.armory.WeaponVault.entityDTO.SuperAdminRequest;
import com.armory.WeaponVault.entityDTO.SuperAdminResponse;
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
 * A delegate to be called by the {@link AuthApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-29T14:12:51.910033071+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public interface AuthApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /auth/login : Super Admin Login
     *
     * @param superAdminRequest  (required)
     * @return Successful login (status code 200)
     *         or Missing email or password (status code 400)
     *         or Invalid credentials (status code 401)
     *         or Account disabled (status code 403)
     *         or Super Admin not found (status code 404)
     * @see AuthApi#superAdminLogin
     */
    default ResponseEntity<SuperAdminResponse> superAdminLogin(SuperAdminRequest superAdminRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"role\" : \"role\", \"phoneNumber\" : \"+1234567890\", \"name\" : \"John Doe\", \"tokenExpiry\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : 0, \"email\" : \"email@example.com\", \"token\" : \"***..\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"role\" : \"role\", \"phoneNumber\" : \"+1234567890\", \"name\" : \"John Doe\", \"tokenExpiry\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : 0, \"email\" : \"email@example.com\", \"token\" : \"***..\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"role\" : \"role\", \"phoneNumber\" : \"+1234567890\", \"name\" : \"John Doe\", \"tokenExpiry\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : 0, \"email\" : \"email@example.com\", \"token\" : \"***..\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"role\" : \"role\", \"phoneNumber\" : \"+1234567890\", \"name\" : \"John Doe\", \"tokenExpiry\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : 0, \"email\" : \"email@example.com\", \"token\" : \"***..\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"role\" : \"role\", \"phoneNumber\" : \"+1234567890\", \"name\" : \"John Doe\", \"tokenExpiry\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : 0, \"email\" : \"email@example.com\", \"token\" : \"***..\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
