package com.armory.WeaponVault.APIs.adminInvitesApi;

import com.armory.WeaponVault.entityDTO.AdminInviteRequest;
import com.armory.WeaponVault.entityDTO.AdminInviteResponse;
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
 * A delegate to be called by the {@link AdminApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-01T14:23:19.910106306+05:30[Asia/Kolkata]", comments = "Generator version: 7.11.0")
public interface AdminApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /admin/invite : Get all admin invites
     *
     * @return A list of all admin invites (status code 200)
     *         or Forbidden - Access Denied (status code 403)
     *         or Internal server error (status code 500)
     * @see AdminApi#getAllAdminInvites
     */
    default ResponseEntity<List<AdminInviteResponse>> getAllAdminInvites() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"message\" : \"Invite sent successfully.\" }, { \"message\" : \"Invite sent successfully.\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /admin/invite : Send Admin Invite
     * The POST Admin Invites API endpoint is designed to create a record for admin invites and send an invitation email to the specified admin user. This process involves generating an invite token and sending an email using a predefined template.
     *
     * @param adminInviteRequest  (required)
     * @return Invite sent successfully (status code 201)
     *         or Missing or invalid parameters (status code 400)
     *         or Organization or super admin not found (status code 404)
     *         or Unexpected server error (status code 500)
     * @see AdminApi#sendAdminInvite
     */
    default ResponseEntity<AdminInviteResponse> sendAdminInvite(AdminInviteRequest adminInviteRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /admin/invite/{inviteId} : Update Admin Invite
     * The PUT Admin Invites API endpoint is used to update an existing admin invite. This can be used to resend the invitation or update the email/other information for the invite.
     *
     * @param inviteId The unique identifier for the admin invite. (required)
     * @param adminInviteRequest  (required)
     * @return Invite updated successfully (status code 200)
     *         or Missing or invalid parameters (status code 400)
     *         or Invite not found or Organization not found (status code 404)
     *         or Unexpected server error (status code 500)
     * @see AdminApi#updateAdminInvite
     */
    default ResponseEntity<AdminInviteResponse> updateAdminInvite(Long inviteId,
        AdminInviteRequest adminInviteRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Invite sent successfully.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
