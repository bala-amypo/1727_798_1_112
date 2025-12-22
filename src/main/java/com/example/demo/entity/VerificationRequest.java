package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_requests")
public class VerificationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ID of the credential being verified
    @Column(nullable = false)
    private Long credentialId;

    // Who requested verification
    @Column(nullable = false)
    private Long requesterId;

    // Status: PENDING / APPROVED / REJECTED
    @Column(nullable = false)
    private String status;

    // Optional comments from verifier
    @Column(length = 500)
    private String remarks;

    // When request was created
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // When request was processed (IMPORTANT – fixes your error)
    private LocalDateTime processedAt;

    // ---------------- CONSTRUCTORS ----------------

    public VerificationRequest() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public VerificationRequest(Long credentialId, Long requesterId) {
        this.credentialId = credentialId;
        this.requesterId = requesterId;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    // ---------------- GETTERS & SETTERS ----------------

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

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }
}
