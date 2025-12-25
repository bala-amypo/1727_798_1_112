// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "audit_trail_records")
// public class AuditTrailRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String action;

//     private String performedBy;

//     private LocalDateTime timestamp;

//     public AuditTrailRecord() {}

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getAction() { return action; }
//     public void setAction(String action) { this.action = action; }

//     public String getPerformedBy() { return performedBy; }
//     public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }

//     public LocalDateTime getTimestamp() { return timestamp; }
//     public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
// }
package com.example.demo.entity;

import java.time.LocalDateTime;

public class AuditTrailRecord {
    private Long id;
    private Long credentialId;
    private LocalDateTime loggedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCredentialId() { return credentialId; }
    public void setCredentialId(Long credentialId) { this.credentialId = credentialId; }

    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
}
