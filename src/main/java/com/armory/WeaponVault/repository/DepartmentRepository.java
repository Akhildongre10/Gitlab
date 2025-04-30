package com.armory.WeaponVault.repository;


import com.armory.WeaponVault.entity.Department;
import com.armory.WeaponVault.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
        Department findByDepartmentId(Long departmentId);
        Department findByDepartmentName(String departmentName);
//        List<Department> findByOrganization(Organization organization);
//        List<Department> findByOrganization_OrganizationId(Long organizationId);

//    @Query("SELECT d FROM Department d WHERE d.organization.organizationId = :organizationId")
//        List<Department> findByOrganizationId(@Param("organizationId") Long organizationId);
//

}
