package com.armory.WeaponVault.mapper;

import com.armory.WeaponVault.entity.Category;
import com.armory.WeaponVault.entity.Manufacturer;
import com.armory.WeaponVault.entityDTO.CategoryDto;
import com.armory.WeaponVault.entityDTO.CategoryDtoInsert;
import org.mapstruct.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses = ManufacturerMapper.class)
public interface CategoryMapper {

    // Mapping from CategoryDto to Category

    Category toEntity(CategoryDto categoryDto);

    // Mapping from Category to CategoryDto
//    @Mapping(target = "manufacturers", ignore = true)
    @Mapping(target = "inventories", ignore = true)  // Ignore the inventoryList to prevent circular reference
    CategoryDto toDto(Category category);

    // You can map lists as well if you want to convert a list of entities to DTOs
//    @IterableMapping(qualifiedByName = "toDto") // Explicitly mapping the list with "toDto"
    List<CategoryDto> toDtoList(List<Category> categories);

    List<Category> toEntityList(List<CategoryDto> categoryDtos);



    // Map Category Entity to CategoryDtoInsert
    @Mapping(target = "manufacturerIds", source = "manufacturers")  // Map manufacturers to manufacturerIds
    CategoryDtoInsert mapToDtoInsertFromCategory(Category category);

    // Map CategoryDtoInsert to Category Entity
    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "inventories", ignore = true)
    @Mapping(target = "manufacturers", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category mapToCategoryFromDtoInsert(CategoryDtoInsert dtoInsert);


    // Helper method to extract manufacturer IDs
    default List<Long> mapManufacturersToIds(List<Manufacturer> manufacturers) {
        if (manufacturers == null) {
            return null;
        }
        return manufacturers.stream()
                .map(Manufacturer::getId)  // Extract IDs from Manufacturer entities
                .collect(Collectors.toList());
    }
}

