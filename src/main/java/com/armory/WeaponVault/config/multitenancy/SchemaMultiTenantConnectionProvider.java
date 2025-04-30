package com.armory.WeaponVault.config.multitenancy;

import jakarta.annotation.Nonnull;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class SchemaMultiTenantConnectionProvider implements MultiTenantConnectionProvider<String>{


    private  final DataSource dataSource;

    public SchemaMultiTenantConnectionProvider(DataSource dataSource){
        this.dataSource =dataSource;
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        System.out.println("SchemaMultiTenantConnectionProvider: Switching to tenant schema: " + tenantIdentifier);
        if (tenantIdentifier == null) {
            throw new IllegalArgumentException("Tenant identifier cannot be null");
        }
        Connection connection = getAnyConnection();
        try {
//            connection.setSchema(tenantIdentifier); // Set schema for PostgreSQL
            connection.createStatement().execute("SET search_path TO "+ tenantIdentifier);
        } catch (SQLException e) {
            throw new SQLException("Failed to set schema to: " + tenantIdentifier, e);
        }
        return connection;
    }


    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        releaseAnyConnection(connection);
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new SQLException("Failed to close connection", e);
            }
        }
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }
    @Override
    public boolean isUnwrappableAs(@Nonnull Class<?> unwrapType) {
        return MultiTenantConnectionProvider.class.isAssignableFrom(unwrapType);
    }

    @Override
    public <T> T unwrap(@Nonnull Class<T> unwrapType) {
        if (isUnwrappableAs(unwrapType)) {
            return unwrapType.cast(this);
        }
        throw new IllegalArgumentException("Cannot unwrap to " + unwrapType);
    }

}




