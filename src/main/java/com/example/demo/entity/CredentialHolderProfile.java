package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credential_holder_profiles")
public class CredentialHolderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;

    // Constructors
    public CredentialHolderProfile() {}

    public CredentialHolderProfile(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
