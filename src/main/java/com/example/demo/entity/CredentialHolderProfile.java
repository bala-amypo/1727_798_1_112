package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credential_holder_profiles")
public class CredentialHolderProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String organization;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    public CredentialHolderProfile() {}
    
    public CredentialHolderProfile(String email, String organization, Boolean active) {
        this.email = email;
        this.organization = organization;
        this.active = active;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialHolderProfile that = (CredentialHolderProfile) o;
        return Objects.equals(id, that.id) && 
               Objects.equals(email, that.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
    
    @Override
    public String toString() {
        return "CredentialHolderProfile{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                ", active=" + active +
                '}';
    }
}