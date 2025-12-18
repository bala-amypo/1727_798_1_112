package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "credentialCode"))
public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long holderId;
    private String credentialCode;
    private String title;
    private String issuer;
    private LocalDate issuedDate;
    private LocalDate expiryDate;
    private String credentialType;
    private String status = "VALID";

    @Lob
    private String metadataJson;

    @ManyToMany
    private Set<VerificationRule> rules;

    // Default constructor
    public CredentialRecord() {}

    // Parameterized constructor
    public CredentialRecord(
            Long holderId,
            String credentialCode,
            String title,
            String issuer,
            LocalDate issuedDate,
            LocalDate expiryDate,
            String credentialType) {

        this.holderId = holderId;
        this.credentialCode = credentialCode;
        this.title = title;
        this.issuer = issuer;
        this.issuedDate = issuedDate;
        this.expiryDate = expiryDate;
        this.credentialType = credentialType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getHolderId() { return holderId; }
    public void setHolderId(Long holderId) { this.holderId = holderId; }

    public String getCredentialCode() { return credentialCode; }
    public void setCredentialCode(String credentialCode) { this.credentialCode = credentialCode; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }

    public LocalDate getIssuedDate() { return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public String getCredentialType() { return credentialType; }
    public void setCredentialType(String credentialType) { this.credentialType = credentialType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMetadataJson() { return metadataJson; }
    public void setMetadataJson(String metadataJson) { this.metadataJson = metadataJson; }

    public Set<VerificationRule> getRules() { return rules; }
    public void setRules(Set<VerificationRule> rules) { this.rules = rules; }
}
