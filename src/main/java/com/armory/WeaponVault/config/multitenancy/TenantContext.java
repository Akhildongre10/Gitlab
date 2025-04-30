package com.armory.WeaponVault.config.multitenancy;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class TenantContext {

    private static final String TENANT_KEY = "";
    public static void setTenant(String tenant) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            requestAttributes.setAttribute(TENANT_KEY, tenant, RequestAttributes.SCOPE_REQUEST);
        }
    }
     public static String getTenant() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return (String) requestAttributes.getAttribute(TENANT_KEY, RequestAttributes.SCOPE_REQUEST);
        }
        return null;
    }

}
