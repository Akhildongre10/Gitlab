    package com.armory.WeaponVault.repository;

    import com.armory.WeaponVault.entity.Organization;
    import org.aspectj.weaver.ast.Or;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface OrganizationRepository extends JpaRepository<Organization,Long> {
        Organization findByOrganizationId(Long organizationId);
        Organization findByOrganizationName(String organizationName);

    }
