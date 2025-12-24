// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class VerificationRequest {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long credentialId;
//     private String verifierName;
//     private String status; // PENDING, APPROVED, REJECTED

//     public VerificationRequest() {
//     }

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

//     public String getVerifierName() {
//         return verifierName;
//     }

//     public void setVerifierName(String verifierName) {
//         this.verifierName = verifierName;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_requests")
public class VerificationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long credentialId;
    private String status;
    private String verificationResult;
    private LocalDateTime requestedAt = LocalDateTime.now();
    private LocalDateTime processedAt;
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getCredentialId() { return credentialId; }
    public void setCredentialId(Long credentialId) { this.credentialId = credentialId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getVerificationResult() { return verificationResult; }
    public void setVerificationResult(String verificationResult) { this.verificationResult = verificationResult; }
    
    public LocalDateTime getRequestedAt() { return requestedAt; }
    public void setRequestedAt(LocalDateTime requestedAt) { this.requestedAt = requestedAt; }
    
    public LocalDateTime getProcessedAt() { return processedAt; }
    public void setProcessedAt(LocalDateTime processedAt) { this.processedAt = processedAt; }
}