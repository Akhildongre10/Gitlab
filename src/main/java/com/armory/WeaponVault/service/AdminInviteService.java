package com.armory.WeaponVault.service;

import com.armory.WeaponVault.entity.AdminInvite;
import com.armory.WeaponVault.repository.AdminInviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AdminInviteService {

    private final AdminInviteRepository adminInviteRepository;

    @Autowired
    public AdminInviteService(AdminInviteRepository adminInviteRepository) {
        this.adminInviteRepository = adminInviteRepository;
    }

    // Get all admin invites
    public List<AdminInvite> getAllAdminInvites() {
        return adminInviteRepository.findAll();
    }

    // Get an admin invite by ID
    public Optional<AdminInvite> getAdminInviteById(Long inviteId) {
        return adminInviteRepository.findById(inviteId);
    }

    // Get an admin invite by email
    public Optional<AdminInvite> getAdminInviteByEmail(String email) {
        return adminInviteRepository.findByEmail(email);
    }

    // Get an admin invite by token
    public Optional<AdminInvite> getAdminInviteByToken(String token) {
        return adminInviteRepository.findByToken(token);
    }

    // Get all admin invites by organization ID
    public List<AdminInvite> getAdminInvitesByOrganization(Long organizationId) {
        return adminInviteRepository.findByOrganization_OrganizationId(organizationId);
    }

    // Create a new admin invite
    @Transactional
    public AdminInvite saveAdminInvite(AdminInvite adminInvite) {
        return adminInviteRepository.save(adminInvite);
    }

    // Update an existing admin invite
    @Transactional
    public AdminInvite updateAdminInvite(AdminInvite adminInvite) {
        return adminInviteRepository.save(adminInvite);
    }

//    // Delete an admin invite by ID
//    @Transactional
//    public boolean deleteAdminInvite(Long inviteId) {
//        if (adminInviteRepository.existsById(inviteId)) {
//            adminInviteRepository.deleteById(inviteId);
//            return true;
//        }
//        return false;
//    }
}
