package com.armory.WeaponVault.config.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class HibernateMultiTenantConfig {

    private final DataSource dataSource;

    public HibernateMultiTenantConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MultiTenantConnectionProvider<String> multiTenantConnectionProvider() {
        return new SchemaMultiTenantConnectionProvider(dataSource);
    }


    @Bean
    public CurrentTenantIdentifierResolver<String> currentTenantIdentifierResolver() {
        return new CurrentTenantIdentifierResolverImpl();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.armory.WeaponVault");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.multiTenancy", "SCHEMA");  // ✅ Enable schema-based multi-tenancy
        properties.put("hibernate.tenant_identifier_resolver", currentTenantIdentifierResolver());
        properties.put("hibernate.multi_tenant_connection_provider", multiTenantConnectionProvider());
//        properties.put("hibernate.hbm2ddl.auto", "update");
//        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.default_schema", "organization_structure");

        em.setJpaPropertyMap(properties);
        return em;
    }

}