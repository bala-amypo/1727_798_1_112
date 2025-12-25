// package com.example.demo.service.impl;

// import com.example.demo.entity.VerificationRequest;
// import com.example.demo.repository.VerificationRequestRepository;
// import com.example.demo.service.VerificationRequestService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class VerificationRequestServiceImpl implements VerificationRequestService {

//     private final VerificationRequestRepository repository;

//     public VerificationRequestServiceImpl(VerificationRequestRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public VerificationRequest create(VerificationRequest request) {
//         return repository.save(request);
//     }

//     @Override
//     public List<VerificationRequest> getAll() {
//         return repository.findAll();
//     }

//     @Override
//     public List<VerificationRequest> getByCredentialId(Long credentialId) {
//         return repository.findByCredentialId(credentialId);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import java.time.LocalDate;
import java.util.List;

public class VerificationRequestServiceImpl implements VerificationRequestService {

    private final VerificationRequestRepository requestRepo;
    private final CredentialRecordService credentialService;
    private final VerificationRuleService ruleService;
    private final AuditTrailService auditService;

    public VerificationRequestServiceImpl(
            VerificationRequestRepository requestRepo,
            CredentialRecordService credentialService,
            VerificationRuleService ruleService,
            AuditTrailService auditService) {

        this.requestRepo = requestRepo;
        this.credentialService = credentialService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        return requestRepo.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest req = requestRepo.findById(requestId).orElseThrow();

        CredentialRecord credential = credentialService.getCredentialByCode(
                req.getCredentialId().toString()
        );

        if (credential != null &&
            credential.getExpiryDate() != null &&
            credential.getExpiryDate().isBefore(LocalDate.now())) {
            req.setStatus("FAILED");
        } else {
            req.setStatus("SUCCESS");
        }

        AuditTrailRecord log = new AuditTrailRecord();
        log.setCredentialId(req.getCredentialId());
        auditService.logEvent(log);

        return requestRepo.save(req);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return requestRepo.findByCredentialId(credentialId);
    }
}
