package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.VerificationRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VerificationRequestServiceImpl
        implements VerificationRequestService {

    private final VerificationRequestRepository repository;
    private final CredentialRecordService credentialService;
    private final VerificationRuleService ruleService;
    private final AuditTrailService auditService;

    // REQUIRED CONSTRUCTOR SIGNATURE & ORDER
    public VerificationRequestServiceImpl(
            VerificationRequestRepository repository,
            CredentialRecordService credentialService,
            VerificationRuleService ruleService,
            AuditTrailService auditService) {

        this.repository = repository;
        this.credentialService = credentialService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        request.setStatus("PENDING");
        return repository.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest request = repository.findById(requestId).orElseThrow();

        CredentialRecord credential =
                credentialService.getCredentialByCode(
                        String.valueOf(request.getCredentialId()));

        if (credential.getExpiryDate().isBefore(LocalDate.now())) {
            request.setStatus("FAILED");
            request.setResultMessage("Credential expired");
        } else {
            request.setStatus("SUCCESS");
            request.setResultMessage("Credential valid");
        }

        AuditTrailRecord audit = new AuditTrailRecord();
        audit.setCredentialId(request.getCredentialId());
        audit.setEventType("VERIFICATION");
        audit.setDetails(request.getStatus());

        auditService.logEvent(audit);
        return repository.save(request);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }

    @Override
    public List<VerificationRequest> getAllRequests() {
        return repository.findAll();
    }
}
