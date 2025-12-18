package com.example.demo.service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditTrailServiceImpl
        implements AuditTrailService {

    private final AuditTrailRecordRepository repository;

    // REQUIRED CONSTRUCTOR SIGNATURE
    public AuditTrailServiceImpl(
            AuditTrailRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditTrailRecord logEvent(AuditTrailRecord record) {
        return repository.save(record);
    }

    @Override
    public List<AuditTrailRecord> getLogsByCredential(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }

    @Override
    public List<AuditTrailRecord> getAllLogs() {
        return repository.findAll();
    }
}
