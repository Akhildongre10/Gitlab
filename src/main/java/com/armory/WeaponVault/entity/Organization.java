package com.armory.WeaponVault.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "organization", schema = "public")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "organization_name")
    private String organizationName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "organization_details", nullable = false)
    private Map<String, Object> organizationDetails;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status")
    private String status;

    // One-to-many relationship with AdminInvite
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdminInvite> adminInvites;

//    // One-to-many relationship with Department
//    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Department> departments;

    // Parameterized Constructor
    public Organization(String organizationName, Map<String, Object> organizationDetails, LocalDateTime createdAt, LocalDateTime updatedAt, String status) {
        this.organizationName = organizationName;
        this.organizationDetails = organizationDetails;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

}


