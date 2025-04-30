package com.armory.WeaponVault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id", nullable = false)
//    private Organization organization;

    @Column(name = "department_name")
    private String departmentName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "department_details", nullable = false)
    private Map<String, Object> departmentDetails;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
