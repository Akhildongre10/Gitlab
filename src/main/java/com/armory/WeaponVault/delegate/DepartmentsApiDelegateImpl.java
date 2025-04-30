package com.armory.WeaponVault.delegate;

import com.armory.WeaponVault.entity.Department;
import com.armory.WeaponVault.entityDTO.DepartmentDto;
import com.armory.WeaponVault.mapper.DepartmentMapper;
import com.armory.WeaponVault.organizationApi.DepartmentsApiDelegate;
import com.armory.WeaponVault.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsApiDelegateImpl implements DepartmentsApiDelegate{

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    //Create Department
    @Override
    public ResponseEntity<DepartmentDto> createDepartment(String xTenantID, DepartmentDto departmentDto) {
        try{

            String departmentName = departmentDto.getDepartmentName().trim();
            Department existingDepartment = departmentService.getDepartmentByName(departmentName)
                                                            .orElse(null);
            if(existingDepartment != null){
               DepartmentDto responseDto = departmentMapper.toDto(existingDepartment);
               return new ResponseEntity<>(responseDto, HttpStatus.CONFLICT);
            }

            Department department = departmentMapper.toEntity(departmentDto);

            if (department.getCreatedAt() == null) {
                department.setCreatedAt(LocalDateTime.now());
            }

            Department savedDepartment = departmentService.saveOrUpdateDepartment(department);

            DepartmentDto savedDepartmentDto = departmentMapper.toDto(savedDepartment);

            return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);

     }   catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
//
//    @Override
//    public ResponseEntity<Void> deleteDepartment(Long departmentId) {
//        boolean isDeleted = departmentService.deleteDepartment(departmentId);
//
//        if (isDeleted) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
//        List<Department> departments = departmentService.getAllDepartments();
//
//        // Map entities to DTOs
//        List<DepartmentDto> departmentDtos = departments.stream()
//                .map(departmentMapper::toDto)
//                .toList();
//
//        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<DepartmentDto> getDepartmentById(Long departmentId) {
//        Optional<Department> departmentOpt = departmentService.getDepartmentById(departmentId);
//
//        if (departmentOpt.isPresent()) {
//            // Map entity to DTO
//            DepartmentDto departmentDto = departmentMapper.toDto(departmentOpt.get());
//            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<DepartmentDto> getDepartmentByName(String departmentName) {
//        Optional<Department> departmentOpt = departmentService.getDepartmentByName(departmentName);
//
//        if (departmentOpt.isPresent()) {
//            // Map entity to DTO
//            DepartmentDto departmentDto = departmentMapper.toDto(departmentOpt.get());
//            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<DepartmentDto> updateDepartment(Long departmentId, DepartmentDto departmentDto) {
//        Optional<Department> departmentOpt = departmentService.getDepartmentById(departmentId);
//
//        if (departmentOpt.isPresent()) {
//            // Map DTO to entity
//            Department department = departmentMapper.toEntity(departmentDto);
//            department.setDepartmentId(departmentId); // Ensure the department ID is set
//
//            // Save the updated department
//            Department updatedDepartment = departmentService.saveOrUpdateDepartment(department);
//
//            // Map entity to DTO and return response
//            DepartmentDto updatedDepartmentDto = departmentMapper.toDto(updatedDepartment);
//            return new ResponseEntity<>(updatedDepartmentDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
