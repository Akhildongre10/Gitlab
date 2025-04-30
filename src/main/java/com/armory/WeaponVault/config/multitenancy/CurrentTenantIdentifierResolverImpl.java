package com.armory.WeaponVault.config.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;


@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver<String>{

    private static final String DEFAULT_TENANT = "public"; // Default schema

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getTenant();
        System.out.println("CurrentTenantIdentifierResolverImpl: Resolving tenant as " + tenant);
        return (tenant != null) ? tenant : DEFAULT_TENANT;
    }
    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}

