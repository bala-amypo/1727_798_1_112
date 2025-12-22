package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "audit_trail_records")
public class AuditTrailRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "credential_id", nullable = false)
    private Long credentialId;
    
    @Column(name = "logged_at")
    private LocalDateTime loggedAt;
    
    @Column(name = "action_type")
    private String actionType;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "performed_by")
    private String performedBy;
    
    public AuditTrailRecord() {}
    
    public AuditTrailRecord(Long credentialId, String actionType, String description, String performedBy) {
        this.credentialId = credentialId;
        this.actionType = actionType;
        this.description = description;
        this.performedBy = performedBy;
        this.loggedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
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
    
    public String getActionType() {
        return actionType;
    }
    
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getPerformedBy() {
        return performedBy;
    }
    
    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditTrailRecord that = (AuditTrailRecord) o;
        return Objects.equals(id, that.id) && 
               Objects.equals(credentialId, that.credentialId) &&
               Objects.equals(loggedAt, that.loggedAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, credentialId, loggedAt);
    }
    
    @Override
    public String toString() {
        return "AuditTrailRecord{" +
                "id=" + id +
                ", credentialId=" + credentialId +
                ", loggedAt=" + loggedAt +
                ", actionType='" + actionType + '\'' +
                ", performedBy='" + performedBy + '\'' +
                '}';
    }
}