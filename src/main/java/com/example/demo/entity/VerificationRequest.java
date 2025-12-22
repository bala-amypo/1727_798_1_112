package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "verification_requests")
public class VerificationRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "credential_id", nullable = false)
    private Long credentialId;
    
    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, SUCCESS, FAILED
    
    @Column(name = "requested_at")
    private LocalDateTime requestedAt = LocalDateTime.now();
    
    @Column(name = "processed_at")
    private LocalDateTime processedAt;
    
    public VerificationRequest() {}
    
    public VerificationRequest(Long credentialId) {
        this.credentialId = credentialId;
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }
    
    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }
    
    public LocalDateTime getProcessedAt() {
        return processedAt;
    }
    
    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerificationRequest that = (VerificationRequest) o;
        return Objects.equals(id, that.id) && 
               Objects.equals(credentialId, that.credentialId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, credentialId);
    }
    
    @Override
    public String toString() {
        return "VerificationRequest{" +
                "id=" + id +
                ", credentialId=" + credentialId +
                ", status='" + status + '\'' +
                ", requestedAt=" + requestedAt +
                '}';
    }
}