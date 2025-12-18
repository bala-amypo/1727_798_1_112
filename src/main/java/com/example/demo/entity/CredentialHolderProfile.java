package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "holderId"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class CredentialHolderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String holderId;
    private String fullName;
    private String email;
    private String organization;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Default constructor
    public CredentialHolderProfile() {}

    // Parameterized constructor
    public CredentialHolderProfile(
            String holderId,
            String fullName,
            String email,
            String organization) {
        this.holderId = holderId;
        this.fullName = fullName;
        this.email = email;
        this.organization = organization;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHolderId() { return holderId; }
    public void setHolderId(String holderId) { this.holderId = holderId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOrganization() { return organization; }
    public void setOrganization(String organization) { this.organization = organization; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
