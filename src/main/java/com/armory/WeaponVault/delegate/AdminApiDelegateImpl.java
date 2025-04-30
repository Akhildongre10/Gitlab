package com.armory.WeaponVault.delegate;

import com.armory.WeaponVault.APIs.adminInvitesApi.AdminApiDelegate;
import com.armory.WeaponVault.entity.AdminInvite;
import com.armory.WeaponVault.entity.Organization;
import com.armory.WeaponVault.entity.SuperAdmin;
import com.armory.WeaponVault.entityDTO.*;
import com.armory.WeaponVault.mapper.AdminInviteMapper;
import com.armory.WeaponVault.repository.SuperAdminRepository;
import com.armory.WeaponVault.security.SuperAdminAuthContextService;
import com.armory.WeaponVault.security.UserPrincipal;
import com.armory.WeaponVault.security.UserService;
import com.armory.WeaponVault.service.AdminInviteService;
import com.armory.WeaponVault.service.EmailService;
import com.armory.WeaponVault.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminApiDelegateImpl implements AdminApiDelegate {

    private static final Logger logger = LoggerFactory.getLogger(AdminApiDelegateImpl.class);

    private final AdminInviteService adminInviteService;
    private final OrganizationService organizationService; // Assuming we have an organization service
    private final EmailService emailService;
    private final AdminInviteMapper adminInviteMapper;
    private final SuperAdminAuthContextService superAdminAuthContextService;


    // Constructor-based dependency injection
    @Autowired
    public AdminApiDelegateImpl(AdminInviteService adminInviteService, AdminInviteMapper adminInviteMapper,OrganizationService organizationService,EmailService emailService,SuperAdminAuthContextService superAdminAuthContextService) {
        this.adminInviteService = adminInviteService;
        this.adminInviteMapper = adminInviteMapper;
        this.organizationService = organizationService;
        this.emailService = emailService;
        this.superAdminAuthContextService = superAdminAuthContextService;
    }

    @Override
    public ResponseEntity<AdminInviteResponse> sendAdminInvite(AdminInviteRequest adminInviteRequest) {

        String mailId = adminInviteRequest.getEmail();
        if (mailId == null || mailId.isEmpty()) {
            return new ResponseEntity<>(
                    new AdminInviteErrorResponse("Email is required"),
                    HttpStatus.BAD_REQUEST
            );
        }
        Organization organization = organizationService.getOrganizationByOrganizationId(adminInviteRequest.getOrganizationId());
        SuperAdmin superAdmin = superAdminAuthContextService.getCurrentSuperAdmin();

        try {

            if ( organization== null || superAdmin == null) {
                return new ResponseEntity<>(
                        new AdminInviteErrorResponse("Organization Or the super admin not found"),
                        HttpStatus.NOT_FOUND
                );
            }

            String subject = "Complete Your AIM Registration";
            String  organizationName= organization.getOrganizationName();

            String invite_token = UUID.randomUUID().toString();
            String registrationLink = "http://localhost:8081/auth/register?token=" + invite_token;

            logger.info("Attempting to send admin invite for email: {}", mailId);
            String message = String.format(
                    "<!DOCTYPE html>" +
                            "<html lang=\"en\">" +
                            "<head>" +
                            "    <meta charset=\"UTF-8\">" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                            "    <title>Admin Invitation</title>" +
                            "</head>" +
                            "<body>" +
                            "    <p>Hello,</p>" +
                            "    <p>You have been invited as an Admin for <strong>%s</strong>.</p>" +
                            "    <p>Click the link below to complete your registration:</p>" +
                            "    <p><a href=\"%s\" style=\"text-decoration: none; color: #007bff;\">Register Now</a></p>" +
                            "    <p>This link expires in 24 hours.</p>" +
                            "    <p>Best Regards,</p>" +
                            "    <p><strong>AIM Team</strong></p>" +
                            "</body>" +
                            "</html>",
                    organizationName, registrationLink);

            emailService.sendSimpleMail(mailId,subject,message);

            AdminInvite adminInvite = adminInviteMapper.toAdminInvite(adminInviteRequest);

            adminInvite.setInvitedBy(superAdmin);
            String token = UUID.randomUUID().toString();

            adminInvite.setToken(token);
            adminInvite.setStatus("pending");
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime expiryDate = localDateTime.plus(1, ChronoUnit.DAYS);  // 24 hours expiry

            adminInvite.setSentAt(localDateTime);
            adminInvite.setExpiresAt(expiryDate);
            adminInvite.setCreatedAt(localDateTime);
            // Save the invite
            adminInviteService.saveAdminInvite(adminInvite);


            // Log success and return success response
            logger.info("Admin invite successfully sent to: {}", mailId);
            AdminInviteSuccessResponse response = new AdminInviteSuccessResponse("Invite sent successfully.");
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            // Log the error and return error response
            logger.error("Failed to send admin invite for email: {}", mailId, e);
            AdminInviteErrorResponse errorResponse = new AdminInviteErrorResponse("Internal server Error Failed to send invite");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<List<AdminInviteResponse>> getAllAdminInvites() {
        try {
            // Attempting to retrieve all admin invites
            logger.info("Attempting to retrieve all admin invites");

            // Fetch all admin invites
            List<AdminInvite> adminInvites = adminInviteService.getAllAdminInvites();

            if (adminInvites.isEmpty()) {
                // If no invites exist, return a 404 not found error
                logger.warn("No admin invites found");
                return new ResponseEntity<>(List.of(new AdminInviteErrorResponse("No admin invites found")), HttpStatus.NOT_FOUND);
            }

            // Convert the list of admin invites to DTO response objects
            List<AdminInviteResponse> responseList = adminInvites.stream()
                    .map(adminInviteMapper::toAdminInviteGetResponse)
                    .collect(Collectors.toList());

            // Log success and return the list of admin invites
            logger.info("Successfully retrieved {} admin invites", adminInvites.size());
            return new ResponseEntity<>(responseList, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Failed to retrieve admin invites", e);
            return new ResponseEntity<>(List.of(new AdminInviteErrorResponse("Internal server error while retrieving admin invites")), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

//    @Override
//    public ResponseEntity<AdminInviteSuccessResponse> updateAdminInvite(Long inviteId, AdminInviteRequest adminInviteRequest) {
//        try {
//            // Log the attempt to update the invite
//            logger.info("Attempting to update admin invite with ID: {}", inviteId);
//
//            // Map the request DTO to the entity and set the inviteId for updating
//            AdminInvite adminInvite = adminInviteMapper.toAdminInvite(adminInviteRequest);
//            adminInvite.setInviteId(inviteId);
//
//            // Update the invite
//            adminInviteService.updateAdminInvite(adminInvite);
//
//            // Log success and return success response
//            logger.info("Admin invite successfully updated for invite ID: {}", inviteId);
//            AdminInviteSuccessResponse response = new AdminInviteSuccessResponse("Invite updated successfully.");
//            return new ResponseEntity<>(response, HttpStatus.OK);
//
//        } catch (Exception e) {
//            // Log the error and return error response
//            logger.error("Failed to update admin invite with ID: {}", inviteId, e);
//            AdminInviteErrorResponse errorResponse = new AdminInviteErrorResponse("Failed to update invite: " + e.getMessage());
//            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

