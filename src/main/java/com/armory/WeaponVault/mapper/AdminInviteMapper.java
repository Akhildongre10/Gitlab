package com.armory.WeaponVault.mapper;

import com.armory.WeaponVault.entity.AdminInvite;
import com.armory.WeaponVault.entity.Organization;
import com.armory.WeaponVault.entityDTO.AdminInviteGetResponse;
import com.armory.WeaponVault.entityDTO.AdminInviteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminInviteMapper {

    @Mapping(source = "organizationId", target = "organization.organizationId")
        // Mapping organizationId to Organization entity
    AdminInvite toAdminInvite(AdminInviteRequest adminInviteRequest);


    // Mapping AdminInvite to AdminInviteGetResponse
    @Mapping(source = "organization.organizationName", target = "organizationName")  // Mapping organization's name
    @Mapping(source = "invitedBy.name", target = "invitedBy")  // Mapping invitedBy's full name
    AdminInviteGetResponse toAdminInviteGetResponse(AdminInvite adminInvite);

    // Mapping a list of AdminInvite to a list of AdminInviteGetResponse
//    List<AdminInviteGetResponse> toAdminInviteGetResponseList(List<AdminInvite> adminInvites);

}
