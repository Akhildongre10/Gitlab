package com.armory.WeaponVault.security;


import com.armory.WeaponVault.config.multitenancy.TenantFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final TokenValidationFilter tokenValidationFilter;
    private final TenantFilter tenantFilter;


    // Constructor Injection to avoid circular dependency
    public SecurityConfig(UserDetailsService userDetailsService,TokenValidationFilter tokenValidationFilter,TenantFilter tenantFilter) {
        this.userDetailsService = userDetailsService;
        this.tokenValidationFilter = tokenValidationFilter;
        this.tenantFilter = tenantFilter;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth
//                                .requestMatchers(
//                        "/swagger-ui/**",
//                        "/swagger-ui.html",
//                        "/v3/api-docs/**",
//                        "/swagger/**",
//                        "/login",
//                        "/auth/login"
//                ).permitAll()
                .requestMatchers("/register","/organizations","/organizations/**","/admin/**").authenticated()
                .anyRequest().permitAll()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(tenantFilter, UsernamePasswordAuthenticationFilter.class)  // Add TenantFilter before TokenValidationFilter
                .addFilterBefore(tokenValidationFilter, UsernamePasswordAuthenticationFilter.class); // TokenValidationFilter after TenantFilter


        return httpSecurity.build();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }



}


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserService userService;
//    private final TokenValidationFilter tokenValidationFilter;
//
//    public SecurityConfig(UserService userService) {
//        this.userService = userService;
//        this.tokenValidationFilter = new TokenValidationFilter(userService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/auth/login", "/register").permitAll()  // Public access to login and register
//                .antMatchers("/organization/**").authenticated()  // Protect the /organization endpoints
//                .and()
//                .addFilterBefore(tokenValidationFilter, UsernamePasswordAuthenticationFilter.class);  // Add custom filter
//    }
//}
