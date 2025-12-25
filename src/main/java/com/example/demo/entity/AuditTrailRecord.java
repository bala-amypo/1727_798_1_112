// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "audit_trail_records")
// public class AuditTrailRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // Related credential
//     @Column(nullable = false)
//     private Long credentialId;

//     // Action performed (e.g. VERIFICATION_SUCCESS / VERIFICATION_FAILED)
//     @Column(nullable = false)
//     private String action;

//     // Who performed the action
//     @Column(nullable = false)
//     private String performedBy;

//     // Optional details
//     @Column(length = 500)
//     private String remarks;

//     // Timestamp of the event
//     @Column(nullable = false)
//     private LocalDateTime loggedAt;

//     // ---------------- CONSTRUCTORS ----------------

//     public AuditTrailRecord() {
//         this.loggedAt = LocalDateTime.now();
//     }

//     public AuditTrailRecord(Long credentialId, String action, String performedBy, String remarks) {
//         this.credentialId = credentialId;
//         this.action = action;
//         this.performedBy = performedBy;
//         this.remarks = remarks;
//         this.loggedAt = LocalDateTime.now();
//     }

//     // ---------------- GETTERS & SETTERS ----------------

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getCredentialId() {
//         return credentialId;
//     }

//     public void setCredentialId(Long credentialId) {
//         this.credentialId = credentialId;
//     }

//     public String getAction() {
//         return action;
//     }

//     public void setAction(String action) {
//         this.action = action;
//     }

//     public String getPerformedBy() {
//         return performedBy;
//     }

//     public void setPerformedBy(String performedBy) {
//         this.performedBy = performedBy;
//     }

//     public String getRemarks() {
//         return remarks;
//     }

//     public void setRemarks(String remarks) {
//         this.remarks = remarks;
//     }

//     public LocalDateTime getLoggedAt() {
//         return loggedAt;
//     }

//     public void setLoggedAt(LocalDateTime loggedAt) {
//         this.loggedAt = loggedAt;
//     }
// }



// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "audit_trail_records")
// public class AuditTrailRecord {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     private Long credentialId;
//     private String eventType;
//     private String eventDetails;
//     private String performedBy;
//     private LocalDateTime loggedAt = LocalDateTime.now();
    
//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public Long getCredentialId() { return credentialId; }
//     public void setCredentialId(Long credentialId) { this.credentialId = credentialId; }
    
//     public String getEventType() { return eventType; }
//     public void setEventType(String eventType) { this.eventType = eventType; }
    
//     public String getEventDetails() { return eventDetails; }
//     public void setEventDetails(String eventDetails) { this.eventDetails = eventDetails; }
    
//     public String getPerformedBy() { return performedBy; }
//     public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }
    
//     public LocalDateTime getLoggedAt() { return loggedAt; }
//     public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuditTrailRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long credentialId;
    private LocalDateTime loggedAt;

    public AuditTrailRecord() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
