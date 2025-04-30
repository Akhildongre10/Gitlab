package com.armory.WeaponVault.repository;

import com.armory.WeaponVault.entity.AdminInvite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminInviteRepository extends JpaRepository<AdminInvite, Long> {

    Optional<AdminInvite> findByEmail(String email);
    List<AdminInvite> findByOrganization_OrganizationId(Long organizationId);
    Optional<AdminInvite> findByToken(String token);

//    List<AdminInvite> findByStatus(String status);

}
