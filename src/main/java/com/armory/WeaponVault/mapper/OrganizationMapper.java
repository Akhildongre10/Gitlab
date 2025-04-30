package com.armory.WeaponVault.mapper;

import com.armory.WeaponVault.entity.Organization;
import com.armory.WeaponVault.entityDTO.OrganizationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;
import java.time.Instant;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    // Create a singleton instance of the mapper
    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    OrganizationDto toDto(Organization organization);

    @Mapping(target = "adminInvites", ignore = true)  // Ignore the adminInvites field
    Organization toEntity(OrganizationDto organizationDto);
}
