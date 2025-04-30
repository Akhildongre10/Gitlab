package com.armory.WeaponVault.security;

import com.armory.WeaponVault.entity.SuperAdmin;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private final SuperAdmin superAdmin;

    public UserPrincipal(SuperAdmin superAdmin) {
        Hibernate.initialize(superAdmin.getAdminInvites());
        this.superAdmin = superAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }


    @Override
    public String getPassword() {
        return superAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return superAdmin.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }
}
