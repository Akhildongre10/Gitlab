package com.armory.WeaponVault.repository;

import com.armory.WeaponVault.entity.Inventory;
import com.armory.WeaponVault.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findByName(String name);

}