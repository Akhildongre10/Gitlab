package com.armory.WeaponVault.service;

import com.armory.WeaponVault.entity.Organization;
import com.armory.WeaponVault.repository.InventoryRepository;
import com.armory.WeaponVault.repository.OrganizationRepository;
import com.armory.WeaponVault.repository.OrganizationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrganizationService {

//    @Autowired
//    private OrganizationRepository organizationRepository;

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    // Create or update an organization
    public Organization createOrganization(Organization organization) {
        Organization newOrgObj = organizationRepository.save(organization);

        Long orgId = newOrgObj.getOrganizationId();
        String schemaName = "schema_" + orgId;
        try {
            entityManager.createNativeQuery("CREATE SCHEMA " + schemaName).executeUpdate();
            executeDDLFile(schemaName);
        } catch (Exception e) {
            log.info("Error:", e);
        }

        return newOrgObj;
    }

    public Organization updateOrganization(Organization organization){
        return organizationRepository.save(organization);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    private void executeDDLFile(String schemaName) {
        try {
            // Load schema.sql from resources
            String ddlStatements = new BufferedReader(new InputStreamReader(
                    new ClassPathResource("schema.sql").getInputStream(), StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining("\n"));

            // Replace CREATE TABLE with schema name
            // ddlStatements = ddlStatements.replaceAll("CREATE TABLE ", "CREATE TABLE " + schemaName + ".");

            ddlStatements = ddlStatements.replaceAll("organization_structure", schemaName);
            // Execute SQL statements
            entityManager.createNativeQuery(ddlStatements).executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to execute DDL file for schema: " + schemaName, e);
        }
    }


    // Get all organizations
    public List<Organization> getAllOrganizations() {

        return organizationRepository.findAll();
    }

    // Get organization by organization ID
    public Organization getOrganizationByOrganizationId(Long organizationId) {
        return organizationRepository.findByOrganizationId(organizationId);
    }

    // Get organization by organization Name
    public Organization getOrganizationByOrganizationName(String organizationName){
        return organizationRepository.findByOrganizationName(organizationName);
    }

    @Transactional
    // Delete Organization by ID
    public boolean deleteOrganization(Long organizationId) {
        if (organizationRepository.existsById(organizationId)) {
            organizationRepository.deleteById(organizationId);
            return true;
        }
        return false;
    }

}

