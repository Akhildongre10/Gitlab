package com.armory.WeaponVault.delegate;

import com.armory.WeaponVault.entityDTO.OrganizationDto;
import com.armory.WeaponVault.entity.Organization;
import com.armory.WeaponVault.organizationApi.OrganizationsApiDelegate;
import com.armory.WeaponVault.service.OrganizationService;
import com.armory.WeaponVault.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationsApiDelegateImpl implements OrganizationsApiDelegate {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrganizationMapper organizationMapper;


    //Create Organization
    @Override
    public ResponseEntity<OrganizationDto> createOrganization(String xTenantID, OrganizationDto organizationDto) {
        try {

            String organizationName =  organizationDto.getOrganizationName().trim();
            Organization existingOrganization = organizationService.getOrganizationByOrganizationName(organizationName);

            if (existingOrganization != null) {
                OrganizationDto responseDto = organizationMapper.toDto(existingOrganization);
                return new ResponseEntity<>(responseDto, HttpStatus.CONFLICT);
            }

            Organization organization = organizationMapper.toEntity(organizationDto);
            organization.setStatus("Active");
            if (organization.getCreatedAt() == null) {
                organization.setCreatedAt(LocalDateTime.now());
            }

            organization = organizationService.createOrganization(organization);

            OrganizationDto responseDto = organizationMapper.toDto(organization);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Delete organization by Id
    @Override
    public ResponseEntity<Void> deleteOrganization(Long organizationId, String authorization) {
        try {
            boolean isDeleted = organizationService.deleteOrganization(organizationId);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //fetch all organization data
    @Override
    public ResponseEntity<List<OrganizationDto>> getAllOrganizations(String xTenantID) {
        try {
            List<Organization> organizations = organizationService.getAllOrganizations();

            List<OrganizationDto> responseDtos = organizations.stream()
                                                            .map(organizationMapper::toDto)
                                                            .collect(Collectors.toList());
            return new ResponseEntity<>(responseDtos, HttpStatus.OK);
        } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get single organization data
    @Override
    public ResponseEntity<OrganizationDto> getOrganizationById(Long organizationId, String xTenantID) {
        try {
            Organization organization = organizationService.getOrganizationByOrganizationId(organizationId);
            if (organization != null) {
                OrganizationDto responseDto = organizationMapper.toDto(organization);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update organization by Id
    @Override
    public ResponseEntity<OrganizationDto> updateOrganization(Long organizationId, String xTenantID, OrganizationDto organizationDto) {
        try {
            Organization organization = organizationService.getOrganizationByOrganizationId(organizationId);
            if (organization != null) {
                organization.setOrganizationName(organizationDto.getOrganizationName());
                organization.setOrganizationDetails(organizationDto.getOrganizationDetails());
                if (organizationDto.getStatus() != null) {
                    organization.setStatus(organizationDto.getStatus());
                }
                organization.setUpdatedAt(LocalDateTime.now());
                organization = organizationService.updateOrganization(organization);
                OrganizationDto responseDto = organizationMapper.toDto(organization);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);          }
    }
}
