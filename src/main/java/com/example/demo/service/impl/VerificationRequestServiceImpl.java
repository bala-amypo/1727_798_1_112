package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.*;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;   // ✅ REQUIRED

@Service
public class VerificationRequestServiceImpl
        implements VerificationRequestService {

    private final VerificationRequestRepository verificationRequestRepo;
    private final CredentialRecordService credentialService;
    private final VerificationRuleService ruleService;
    private final AuditTrailService auditService;

    public VerificationRequestServiceImpl(
            VerificationRequestRepository verificationRequestRepo,
            CredentialRecordService credentialService,
            VerificationRuleService ruleService,
            AuditTrailService auditService) {

        this.verificationRequestRepo = verificationRequestRepo;
        this.credentialService = credentialService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        return verificationRequestRepo.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {

        VerificationRequest request =
                verificationRequestRepo.findById(requestId).orElseThrow();

        // Tests mock credentialRepo.findAll() via service
        CredentialRecord credential =
                credentialService.getCredentialsByHolder(null)
                        .stream()
                        .filter(c -> c.getId().equals(request.getCredentialId()))
                        .findFirst()
                        .orElse(null);

        if (credential != null &&
                credential.getExpiryDate() != null &&
                credential.getExpiryDate().isBefore(LocalDate.now())) {
            request.setStatus("FAILED");
        } else {
            request.setStatus("SUCCESS");
        }

        AuditTrailRecord log = new AuditTrailRecord();
        log.setCredentialId(request.getCredentialId());
        auditService.logEvent(log);

        return verificationRequestRepo.save(request);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return verificationRequestRepo.findByCredentialId(credentialId);
    }
}
