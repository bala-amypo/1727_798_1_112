package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;

import java.time.LocalDate;
import java.util.List;

public class CredentialRecordServiceImpl implements CredentialRecordService {

    private final CredentialRecordRepository credentialRepo;

    // ✅ Constructor EXACTLY as tests expect
    public CredentialRecordServiceImpl(CredentialRecordRepository credentialRepo) {
        this.credentialRepo = credentialRepo;
    }

    // --------------------------------------------------
    // CREATE CREDENTIAL
    // --------------------------------------------------
    @Override
    public CredentialRecord createCredential(CredentialRecord record) {

        // Expiry handling
        if (record.getExpiryDate() != null &&
                record.getExpiryDate().isBefore(LocalDate.now())) {
            record.setStatus("EXPIRED");
        }
        // Default status
        else if (record.getStatus() == null) {
            record.setStatus("VALID");
        }

        return credentialRepo.save(record);
    }

    // --------------------------------------------------
    // UPDATE CREDENTIAL
    // --------------------------------------------------
    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord update) {

        CredentialRecord existing =
                credentialRepo.findById(id).orElseThrow();

        existing.setCredentialCode(update.getCredentialCode());
        return credentialRepo.save(existing);
    }

    // --------------------------------------------------
    // GET BY HOLDER
    // --------------------------------------------------
    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return credentialRepo.findByHolderId(holderId);
    }

    // --------------------------------------------------
    // GET BY CODE
    // --------------------------------------------------
    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return credentialRepo.findByCredentialCode(code).orElse(null);
    }

    // --------------------------------------------------
    // 🔴 REQUIRED FOR TEST 61 & 62
    // --------------------------------------------------
    public List<CredentialRecord> getAllCredentials() {
        return credentialRepo.findAll();
    }
}
