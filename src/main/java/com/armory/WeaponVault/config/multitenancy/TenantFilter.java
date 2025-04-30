package com.armory.WeaponVault.config.multitenancy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.*;
import java.io.IOException;

@Component
public class TenantFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, @Nullable HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        String tenant = request.getHeader("X-Tenant-ID");

        if (tenant != null && !tenant.trim().isEmpty()) {
            tenant = tenant.trim();
            if(!tenant.equalsIgnoreCase("public")){
            tenant="schema_"+tenant;
            }
            TenantContext.setTenant(tenant);

        }
        filterChain.doFilter(request, response);
    }
}


