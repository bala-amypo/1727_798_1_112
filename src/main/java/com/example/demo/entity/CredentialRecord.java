package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "credential_records")
public class CredentialRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "holder_id", nullable = false)
    private Long holderId;
    
    @Column(name = "credential_code", nullable = false, unique = true)
    private String credentialCode;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String issuer;
    
    @Column(name = "credential_type", nullable = false)
    private String credentialType; // CERTIFICATE, LICENSE, etc.
    
    @Column(nullable = false)
    private String status = "VALID"; // VALID, EXPIRED
    
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    
    @Column(name = "metadata_json", columnDefinition = "TEXT")
    private String metadataJson;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "credential_verification_rules",
        joinColumns = @JoinColumn(name = "credential_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<VerificationRule> rules = new HashSet<>();
    
    public CredentialRecord() {}
    
    public CredentialRecord(Long holderId, String credentialCode, String title, 
                           String issuer, String credentialType, LocalDate expiryDate) {
        this.holderId = holderId;
        this.credentialCode = credentialCode;
        this.title = title;
        this.issuer = issuer;
        this.credentialType = credentialType;
        this.expiryDate = expiryDate;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getHolderId() {
        return holderId;
    }
    
    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }
    
    public String getCredentialCode() {
        return credentialCode;
    }
    
    public void setCredentialCode(String credentialCode) {
        this.credentialCode = credentialCode;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getIssuer() {
        return issuer;
    }
    
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    
    public String getCredentialType() {
        return credentialType;
    }
    
    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public String getMetadataJson() {
        return metadataJson;
    }
    
    public void setMetadataJson(String metadataJson) {
        this.metadataJson = metadataJson;
    }
    
    public Set<VerificationRule> getRules() {
        return rules;
    }
    
    public void setRules(Set<VerificationRule> rules) {
        this.rules = rules;
    }
    
    public void addRule(VerificationRule rule) {
        this.rules.add(rule);
    }
    
    public void removeRule(VerificationRule rule) {
        this.rules.remove(rule);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialRecord that = (CredentialRecord) o;
        return Objects.equals(id, that.id) && 
               Objects.equals(credentialCode, that.credentialCode);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, credentialCode);
    }
    
    @Override
    public String toString() {
        return "CredentialRecord{" +
                "id=" + id +
                ", holderId=" + holderId +
                ", credentialCode='" + credentialCode + '\'' +
                ", title='" + title + '\'' +
                ", issuer='" + issuer + '\'' +
                ", credentialType='" + credentialType + '\'' +
                ", status='" + status + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}