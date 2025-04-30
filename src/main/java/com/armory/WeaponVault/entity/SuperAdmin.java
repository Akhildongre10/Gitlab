package com.armory.WeaponVault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "super_admins", schema = "public")
public class SuperAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "token")
    private String token;

    @Column(name = "token_expiry")
    private LocalDateTime tokenExpiry;

    // One-to-many relationship with AdminInvite
    @OneToMany(mappedBy = "invitedBy",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdminInvite> adminInvites;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public SuperAdmin(String email,String password, String name, String phoneNumber, String token,LocalDateTime tokenExpiry ,LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.tokenExpiry = tokenExpiry;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}






