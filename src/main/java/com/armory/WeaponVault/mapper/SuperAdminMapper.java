package com.armory.WeaponVault.mapper;

import com.armory.WeaponVault.entity.SuperAdmin;
import com.armory.WeaponVault.entityDTO.SuperAdminRequest;
import com.armory.WeaponVault.entityDTO.SuperAdminSuccessResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SuperAdminMapper {

    SuperAdminMapper INSTANCE = Mappers.getMapper(SuperAdminMapper.class);

    // Mapping from SuperAdminRequest to SuperAdmin
//    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
//    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "adminInvites", ignore = true) // Ignore adminInvites in the response
    SuperAdmin toEntity(SuperAdminRequest request);

    // Mapping from SuperAdmin to SuperAdminSuccessResponse
    @Mapping(target = "role", ignore = true)
    SuperAdminSuccessResponse toResponse(SuperAdmin superAdmin);

    // Mapping from SuperAdminRequest to SuperAdminSuccessResponse (if needed)
    @Mapping(target = "id", ignore = true)
    SuperAdminSuccessResponse toResponseFromRequest(SuperAdminRequest request);

}
