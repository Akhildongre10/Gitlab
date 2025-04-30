package com.armory.WeaponVault.security;

import com.armory.WeaponVault.entity.SuperAdmin;
import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SuperAdminAuthContextService {

    public SuperAdmin getCurrentSuperAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
//            return
            SuperAdmin superAdmin = ((UserPrincipal) authentication.getPrincipal()).getSuperAdmin();
//            Hibernate.initialize(superAdmin.getAdminInvites());  // This ensures the entity is fully loaded
            return superAdmin;
        }
        return null;
    }
}
