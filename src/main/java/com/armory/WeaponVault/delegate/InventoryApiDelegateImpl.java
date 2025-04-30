package com.armory.WeaponVault.delegate;

import com.armory.WeaponVault.entity.Category;
import com.armory.WeaponVault.entityDTO.InventoryDto;
import com.armory.WeaponVault.entity.Inventory;
import com.armory.WeaponVault.entityDTO.InventoryDtoId;
import com.armory.WeaponVault.organizationApi.InventoryApiDelegate;
import com.armory.WeaponVault.service.InventoryService;
import com.armory.WeaponVault.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryApiDelegateImpl implements InventoryApiDelegate {

//    @Autowired
//    private InventoryService inventoryService;
//    @Autowired
//    private InventoryMapper inventoryMapper;

    private final InventoryService inventoryService;
    private final InventoryMapper inventoryMapper;

    // Constructor injection
    @Autowired
    public InventoryApiDelegateImpl(InventoryService inventoryService, InventoryMapper inventoryMapper) {
        this.inventoryService = inventoryService;
        this.inventoryMapper = inventoryMapper;
    }

    // Create a new inventory
    @Override
    public ResponseEntity<InventoryDto> createInventory(String xTenantID, InventoryDtoId inventoryDtoId) {
        try {
            String serialNo = inventoryDtoId.getSerialNo().trim();
            Optional<Inventory> existingInventory = inventoryService.getInventoryBySerialNo(serialNo);

            if (existingInventory.isPresent()) {
                InventoryDto responseDto = inventoryMapper.toDto(existingInventory.get());
                return new ResponseEntity<>(responseDto, HttpStatus.CONFLICT);
            }

            Inventory inventory = inventoryMapper.toEntityFromDtoId(inventoryDtoId);
            if (inventory.getCreatedAt() == null) {
                inventory.setCreatedAt(LocalDateTime.now());
            }

            inventory = inventoryService.saveOrUpdateInventory(inventory);
                InventoryDto responseDto = inventoryMapper.toDto(inventory);
                return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete an inventory by ID
    @Override
    public ResponseEntity<Void> deleteInventory(Long inventoryId, String xTenantID) {
        try {
            boolean isDeleted = inventoryService.deleteInventory(inventoryId);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);        }
    }

    // Get all inventories
    @Override
    public ResponseEntity<List<InventoryDto>> getAllInventories(String xTenantID) {
        try {
            List<Inventory> inventories = inventoryService.getAllInventories();

            List<InventoryDto> responseDtos = inventories.stream()
                    .map(inventoryMapper::toDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(responseDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get inventory by ID
    @Override
    public ResponseEntity<InventoryDto> getInventoryById(Long inventoryId, String xTenantID) {
        try {
            Optional<Inventory> inventory = inventoryService.getInventoryByInventoryId(inventoryId);
            if (inventory.isPresent()) {
                InventoryDto responseDto = inventoryMapper.toDto(inventory.get());
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get inventories by category ID
    @Override
    public ResponseEntity<List<InventoryDto>> getInventoriesByCategoryId(Long categoryId, String xTenantID) {
        try {
            List<Inventory> inventories = inventoryService.getInventoriesByCategoryId(categoryId);

            List<InventoryDto> responseDtos = inventories.stream()
                    .map(inventoryMapper::toDto)
                    .collect(Collectors.toList());
//
//            if(responseDtos.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//            }
            return new ResponseEntity<>(responseDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get inventory by serial number
    @Override
    public ResponseEntity<InventoryDto> getInventoryBySerialNo(String serialNo, String xTenantID) {
        try {
            serialNo = serialNo.trim();
            Optional<Inventory> inventory = inventoryService.getInventoryBySerialNo(serialNo);
            if (inventory.isPresent()) {
                InventoryDto responseDto = inventoryMapper.toDto(inventory.get());
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an inventory by ID
    @Override
    public ResponseEntity<InventoryDto> updateInventory(Long inventoryId, String xTenantID, InventoryDtoId inventoryDtoId) {
        try {
            Optional<Inventory> existingInventory = inventoryService.getInventoryByInventoryId(inventoryId);
            if (existingInventory.isPresent()) {
                Inventory inventory = existingInventory.get();
                inventory.setSerialNo(inventoryDtoId.getSerialNo());
                inventory.setInventoryDetails(inventoryDtoId.getInventoryDetails());
                Category category = new Category();
                category.setCategoryId(inventoryDtoId.getCategoryId());
                inventory.setCategory(category);
//                inventory.setProductId(inventoryDto.getProductId());
                if (inventoryDtoId.getUpdatedAt() == null) {
                    inventory.setUpdatedAt(LocalDateTime.now());
                }

                inventory = inventoryService.saveOrUpdateInventory(inventory);
                InventoryDto responseDto = inventoryMapper.toDto(inventory);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);        }
    }
}
