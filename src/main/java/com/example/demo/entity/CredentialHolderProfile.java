// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class CredentialHolderProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String email;

//     public CredentialHolderProfile() {
//     }

//     public CredentialHolderProfile(String name, String email) {
//         this.name = name;
//         this.email = email;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {      // ✅ FIXED (was missing earlier)
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }
// }



// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "credential_holder_profiles")
// public class CredentialHolderProfile {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     private String fullName;
//     private String email;
//     private String organization;
//     private Boolean active = true;
    
//     @Column(name = "created_at")
//     private LocalDateTime createdAt = LocalDateTime.now();
    
//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }
    
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
    
//     public String getOrganization() { return organization; }
//     public void setOrganization(String organization) { this.organization = organization; }
    
//     public Boolean getActive() { return active; }
//     public void setActive(Boolean active) { this.active = active; }
    
//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }


package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CredentialHolderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String organization;
    private Boolean active;

    public CredentialHolderProfile() {}

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
}
