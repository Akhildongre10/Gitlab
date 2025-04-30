package com.armory.WeaponVault.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"organization", "invitedBy"})
@Table(name = "admin_invites", schema = "public")
public class AdminInvite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long inviteId;

    @Column(nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "invited_by_id", nullable = false)
    private SuperAdmin invitedBy;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String status;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt = LocalDateTime.now();

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "accepted_at")
    private LocalDateTime acceptedAt;

    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public AdminInvite(String email, String fullName, Organization organization, SuperAdmin invitedBy, String token, String status, LocalDateTime expiresAt, LocalDateTime acceptedAt, LocalDateTime revokedAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.email = email;
        this.fullName = fullName;
        this.organization = organization;
        this.invitedBy = invitedBy;
        this.token = token;
        this.status = status;
        this.expiresAt = expiresAt;
        this.acceptedAt = acceptedAt;
        this.revokedAt = revokedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
