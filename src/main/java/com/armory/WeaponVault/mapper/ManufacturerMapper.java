package com.armory.WeaponVault.mapper;

import com.armory.WeaponVault.entity.Manufacturer;
import com.armory.WeaponVault.entityDTO.ManufacturerDto;
import com.armory.WeaponVault.entityDTO.ManufacturerDtoInsert;
import com.armory.WeaponVault.mapper.CategoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class) // Component model 'spring' to make it a Spring Bean
public interface ManufacturerMapper {

    ManufacturerMapper INSTANCE = Mappers.getMapper(ManufacturerMapper.class);

    /**
     * Convert Manufacturer entity to ManufacturerDto.
     * @param manufacturer The Manufacturer entity.
     * @return The ManufacturerDto.
     */
    @Mapping(target = "categories", ignore = true) // Ignore category to prevent recursion
    ManufacturerDto toManufacturerDto(Manufacturer manufacturer);

    /**
     * Convert ManufacturerDto to Manufacturer entity.
     * Since the field names are the same, MapStruct will automatically map them.
     * @param manufacturerDto The ManufacturerDto.
     * @return The Manufacturer entity.
     */
    @Mapping(target = "categories", ignore = true) // Ignore category to prevent recursion
    Manufacturer toManufacturerEntity(ManufacturerDto manufacturerDto);

    /**
     * Convert a list of Manufacturer entities to ManufacturerDto list.
     * @param manufacturers List of Manufacturer entities.
     * @return List of ManufacturerDto.
     */
    List<ManufacturerDto> toManufacturerDtoList(List<Manufacturer> manufacturers);

    /**
     * Convert a list of ManufacturerDto to Manufacturer entities list.
     * @param manufacturerDtos List of ManufacturerDto.
     * @return List of Manufacturer entities.
     */
    List<Manufacturer> toManufacturerEntityList(List<ManufacturerDto> manufacturerDtos);


    /**
     * Convert ManufacturerDtoInsert to Manufacturer entity.
     * This method is specifically for mapping from ManufacturerDtoInsert to Manufacturer.
     * @param manufacturerDtoInsert The ManufacturerDtoInsert.
     * @return The Manufacturer entity.
     */

    @Mapping(target = "categories", ignore = true) // Ignore category to prevent recursion
    Manufacturer toManufacturerEntityFromInsert(ManufacturerDtoInsert manufacturerDtoInsert);

    /**
     * Convert Manufacturer entity to ManufacturerDtoInsert.
     * This method is for mapping from Manufacturer to ManufacturerDtoInsert.
     * @param manufacturer The Manufacturer entity.
     * @return The ManufacturerDtoInsert.
     */
    ManufacturerDtoInsert toManufacturerDtoInsert(Manufacturer manufacturer);




}
