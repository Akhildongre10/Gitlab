package com.armory.WeaponVault.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"inventories", "manufacturers"})
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    // One-to-many relationship with inventory
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Inventory> inventories;

    @ManyToMany()
    @JoinTable(
            name = "manufacturer_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id")
    )
    private List<Manufacturer> manufacturers;


    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "category_details", nullable = false)
    private Map<String,Object> categoryDetails;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Category( String categoryName, Map<String,Object> categoryDetails, LocalDateTime createdAt, LocalDateTime updatedAt){
//        this.manufacturers = manufacturers;
        this.categoryName = categoryName;
        this.categoryDetails = categoryDetails;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
