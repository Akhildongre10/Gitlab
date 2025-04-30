package com.armory.WeaponVault.security;

import com.armory.WeaponVault.entity.SuperAdmin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.*;
import java.io.IOException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class TokenValidationFilter extends OncePerRequestFilter {

    private final UserService userService;

    public TokenValidationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,@Nullable HttpServletResponse response,@NonNull FilterChain filterChain)
            throws ServletException, IOException {

        // Extract token from Authorization header
        String token = extractTokenFromRequest(request);

        if (token != null) {
            // Find SuperAdmin by token
            SuperAdmin superAdmin = userService.findByToken(token);

            if (superAdmin != null && superAdmin.getTokenExpiry().isAfter(LocalDateTime.now())) {

                UserPrincipal userPrincipal = new UserPrincipal(superAdmin);
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                        userPrincipal, null, userPrincipal.getAuthorities()));
            } else {
                if (response != null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Invalid or expired token");
                }
            }
        }

        // Continue the filter chain to other filters (including TenantFilter)
        filterChain.doFilter(request, response);
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);  // Remove "Bearer " prefix
        }
        return null;
    }
}
