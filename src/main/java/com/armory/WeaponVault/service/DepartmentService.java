package com.armory.WeaponVault.service;


import com.armory.WeaponVault.entity.Department;
import com.armory.WeaponVault.entity.Organization;
import com.armory.WeaponVault.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create or update a Department
    public Department saveOrUpdateDepartment(Department department) {
        return departmentRepository.save(department);
    }
    // Get Department by ID
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    // Get Department by Name
    public Optional<Department> getDepartmentByName(String departmentName) {
        return Optional.ofNullable(departmentRepository.findByDepartmentName(departmentName));
    }

    // Delete Department
    public boolean deleteDepartment(Long departmentId) {
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
            return true;
        }
        return false;
    }
    // Get All Departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

//    // Get Departments by Organization Entity
//    public List<Department> getDepartmentsByOrganization(Organization organization) {
//        return departmentRepository.findByOrganization(organization);
//    }
//
//    // Get Departments by Organization ID
//    public List<Department> getDepartmentsByOrganizationId(Long organizationId) {
//        return departmentRepository.findByOrganization_OrganizationId(organizationId);
//    }



}
