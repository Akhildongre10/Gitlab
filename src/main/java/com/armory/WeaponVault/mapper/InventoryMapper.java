package com.armory.WeaponVault.mapper;

import com.armory.WeaponVault.entity.Inventory;
import com.armory.WeaponVault.entityDTO.InventoryDto;
import com.armory.WeaponVault.entity.Category;
import com.armory.WeaponVault.entityDTO.InventoryDtoId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)  // Use the CategoryMapper
public interface InventoryMapper {

    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    // Mapping Inventory entity to InventoryDto
    @Mapping(source = "category", target = "category")  // Map category entity to category DTO
    InventoryDto toDto(Inventory inventory);



    // Mapping InventoryDto to Inventory entity
    @Mapping(source = "category", target = "category")  // Map category DTO to category entity
    Inventory toEntity(InventoryDto inventoryDto);


    // Mapping InventoryDtoId to Inventory entity
    @Mapping(source = "categoryId", target = "category.categoryId")  // Map categoryId to category entity
    Inventory toEntityFromDtoId(InventoryDtoId inventoryDtoId);
}
