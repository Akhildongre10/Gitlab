package com.armory.WeaponVault.service;

import com.armory.WeaponVault.entity.Inventory;
import com.armory.WeaponVault.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

//    @Autowired
//    private InventoryRepository inventoryRepository;

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    // Get all inventories
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    // Create or update an inventory
    @Transactional
    public Inventory saveOrUpdateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Get an inventory by ID
    public Optional<Inventory> getInventoryByInventoryId(Long inventoryId) {
        return inventoryRepository.findByInventoryId(inventoryId);
    }

    // Get an inventory by serial number
    public Optional<Inventory> getInventoryBySerialNo(String serialNo) {
        return inventoryRepository.findBySerialNo(serialNo);
    }

    // Get inventories by category ID
    public List<Inventory> getInventoriesByCategoryId(Long categoryId) {
        return inventoryRepository.findAllByCategory_CategoryId(categoryId);
    }

    @Transactional
    // Delete an inventory by Id
    public boolean deleteInventory(Long inventoryId) {
        if(inventoryRepository.existsById(inventoryId)) {
            inventoryRepository.deleteById(inventoryId);
            return true;
        }
        return false;

    }
}
