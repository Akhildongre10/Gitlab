package com.armory.WeaponVault.delegate;

import com.armory.WeaponVault.entity.SuperAdmin;
import com.armory.WeaponVault.entityDTO.SuperAdminErrorResponse;
import com.armory.WeaponVault.entityDTO.SuperAdminRequest;
import com.armory.WeaponVault.entityDTO.SuperAdminResponse;
import com.armory.WeaponVault.entityDTO.SuperAdminSuccessResponse;
import com.armory.WeaponVault.mapper.SuperAdminMapper;
import com.armory.WeaponVault.organizationApi.AuthApiDelegate;
import com.armory.WeaponVault.security.UserPrincipal;
import com.armory.WeaponVault.security.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class AuthApiDelegateImpl implements AuthApiDelegate {
    private static final Logger logger = LoggerFactory.getLogger(AuthApiDelegateImpl.class);

    private final UserService userService;

    private final SuperAdminMapper superAdminMapper;


    public AuthApiDelegateImpl(UserService userService,SuperAdminMapper superAdminMapper) {
        this.userService = userService;
        this.superAdminMapper = superAdminMapper;
    }

    @Override
    public ResponseEntity<SuperAdminResponse> superAdminLogin(SuperAdminRequest superAdminRequest) {

        if (superAdminRequest.getEmail() == null || superAdminRequest.getEmail().isEmpty() ||
                superAdminRequest.getPassword() == null || superAdminRequest.getPassword().isEmpty()) {
            logger.warn("Login attempt with missing email or password");

            return new ResponseEntity<>(
                    new SuperAdminErrorResponse("Email and password are required"),
                    HttpStatus.BAD_REQUEST
            );
        }
        SuperAdmin superAdmin;
        try {
            logger.info("Attempting to load SuperAdmin with email: {}", superAdminRequest.getEmail());
            UserDetails userDetails = userService.loadUserByUsername(superAdminRequest.getEmail());
            superAdmin = ((UserPrincipal) userDetails).getSuperAdmin();
        } catch (UsernameNotFoundException e) {
            logger.error("SuperAdmin account not found for email: {}", superAdminRequest.getEmail(), e);
            return new ResponseEntity<>(
                    new SuperAdminErrorResponse("Super Admin account not found"),
                    HttpStatus.NOT_FOUND
            );
        }


//        // Check if the super admin account is disabled (e.g., if there's a flag in the database)
//        if (userService.isAccountDisabled(superAdminRequest.getEmail())) {
//            return new ResponseEntity<>(
//                    new SuperAdminErrorResponse("403 Account disabled"),
//                    HttpStatus.FORBIDDEN
//            );
//        }


        // Authenticate the super admin using the provided credentials
        logger.info("Authenticating SuperAdmin with email: {}", superAdminRequest.getEmail());
        boolean isAuthenticated = userService.authenticate(superAdminRequest.getEmail(), superAdminRequest.getPassword());

        if (!isAuthenticated) {
            logger.warn("Authentication failed for SuperAdmin with email: {}", superAdminRequest.getEmail());
            return new ResponseEntity<>(
                    new SuperAdminErrorResponse("Invalid email or password"),
                    HttpStatus.UNAUTHORIZED
            );
        }
        else {
            logger.info("Successfully authenticated SuperAdmin with email: {}", superAdminRequest.getEmail());
            String token = UUID.randomUUID().toString();

            // Set the expiry time to 24 hours from now
            LocalDateTime expiryDate = LocalDateTime.now().plus(1, ChronoUnit.DAYS);  // 24 hours expiry

            superAdmin.setToken(token);
            superAdmin.setTokenExpiry(expiryDate);
            logger.info("Generated token for SuperAdmin with email: {}", superAdminRequest.getEmail());
            try{
            superAdmin = userService.updateToken(superAdmin);
            }
            catch (Exception e){
                logger.error("Failed to generate token for SuperAdmin with email: {}", superAdminRequest.getEmail(), e);
                return new ResponseEntity<>(new SuperAdminErrorResponse("Failed to generate the Token"),HttpStatus.INTERNAL_SERVER_ERROR);
            }

            SuperAdminSuccessResponse response = superAdminMapper.toResponse(superAdmin);
            logger.info("Token successfully updated for SuperAdmin with email: {}", superAdminRequest.getEmail());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
}

