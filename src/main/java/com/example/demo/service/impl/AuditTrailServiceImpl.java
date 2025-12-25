package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrialRecord;
import com.example.demo.repository.AuditTrialRecordRepository;
import com.example.demo.service.AuditTrailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditTrailServiceImpl implements AuditTrailService {

    private final AuditTrialRecordRepository repository;

    public AuditTrailServiceImpl(AuditTrialRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditTrialRecord create(AuditTrialRecord record) {
        return repository.save(record);
    }

    @Override
    public List<AuditTrialRecord> getByCredentialId(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }
}
