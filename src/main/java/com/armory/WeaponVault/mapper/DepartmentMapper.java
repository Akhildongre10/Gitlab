package com.armory.WeaponVault.mapper;

import com.armory.WeaponVault.entity.Department;
import com.armory.WeaponVault.entityDTO.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface DepartmentMapper {

//    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto toDto(Department department);

    Department toEntity(DepartmentDto departmentDto);

}
