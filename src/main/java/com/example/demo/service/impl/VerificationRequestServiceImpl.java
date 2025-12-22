package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.entity.VerificationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.AuditTrailService;
import com.example.demo.service.VerificationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class VerificationRequestServiceImpl implements VerificationRequestService {
    
    private final VerificationRequestRepository verificationRequestRepository;
    private final CredentialRecordRepository credentialRepository;
    private final VerificationRuleRepository ruleRepository;
    private final AuditTrailService auditTrailService;
    
    @Autowired
    public VerificationRequestServiceImpl(
            VerificationRequestRepository verificationRequestRepository,
            CredentialRecordRepository credentialRepository,
            VerificationRuleRepository ruleRepository,
            AuditTrailService auditTrailService) {
        this.verificationRequestRepository = verificationRequestRepository;
        this.credentialRepository = credentialRepository;
        this.ruleRepository = ruleRepository;
        this.auditTrailService = auditTrailService;
    }
    
    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        return verificationRequestRepository.save(request);
    }
    
    @Override
    public VerificationRequest processVerification(Long requestId) {
        // Load the request
        VerificationRequest request = verificationRequestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("VerificationRequest", "id", requestId));
        
        // Locate the corresponding credential
        CredentialRecord credential = credentialRepository.findById(request.getCredentialId())
                .orElseThrow(() -> new ResourceNotFoundException("CredentialRecord", "id", request.getCredentialId()));
        
        // Fetch active rules
        List<VerificationRule> activeRules = ruleRepository.findByActiveTrue();
        
        // Check if credential is expired
        boolean isExpired = credential.getExpiryDate() != null && 
                           credential.getExpiryDate().isBefore(LocalDate.now());
        
        // Determine verification status
        if (isExpired) {
            request.setStatus("FAILED");
        } else {
            request.setStatus("SUCCESS");
        }
        
        request.setProcessedAt(LocalDateTime.now());
        
        // Create audit trail record
        AuditTrailRecord auditRecord = new AuditTrailRecord(
            request.getCredentialId(),
            "VERIFICATION_PROCESSED",
            String.format("Verification request %d processed. Status: %s. Active rules applied: %d", 
                         requestId, request.getStatus(), activeRules.size()),
            "SYSTEM"
        );
        auditTrailService.logEvent(auditRecord);
        
        // Save the updated request
        return verificationRequestRepository.save(request);
    }
    
    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return verificationRequestRepository.findByCredentialId(credentialId);
    }
}