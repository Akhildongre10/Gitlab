package com.armory.WeaponVault.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;



@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "category")
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;

    //Many-to_one relationship with category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;

//
//    @Column(name = "asset_item_number")
//    private String assetItemNumber;

    @Column(name = "serial_no")
    private String serialNo;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "inventory_details", nullable = false)
    private Map<String,Object> inventoryDetails;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Inventory(Category category, String serialNo, Map<String,Object> inventoryDetails, LocalDateTime createdAt,LocalDateTime updatedAt ){
        this.category =category;
//        this.assetItemNumber = assetItemNumber;
        this.serialNo = serialNo;
        this.inventoryDetails = inventoryDetails;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
