package com.armory.WeaponVault.repository;

import com.armory.WeaponVault.entity.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {

    SuperAdmin findByEmail(String email);

    SuperAdmin findByToken(String token);

    Optional<SuperAdmin> findByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);


}
