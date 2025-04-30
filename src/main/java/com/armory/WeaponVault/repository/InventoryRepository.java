package com.armory.WeaponVault.repository;

import com.armory.WeaponVault.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByInventoryId(Long inventoryId);

    Optional<Inventory> findBySerialNo(String serialNo);

    List<Inventory> findAllByCategory_CategoryId(Long categoryId);

}
