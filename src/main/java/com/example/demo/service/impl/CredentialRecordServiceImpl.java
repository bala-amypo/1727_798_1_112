package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CredentialRecordServiceImpl
        implements CredentialRecordService {

    private final CredentialRecordRepository credentialRepo;

    public CredentialRecordServiceImpl(
            CredentialRecordRepository credentialRepo) {
        this.credentialRepo = credentialRepo;
    }

    @Override
    public CredentialRecord createCredential(CredentialRecord record) {

        if (record.getExpiryDate() != null &&
                record.getExpiryDate().isBefore(LocalDate.now())) {
            record.setStatus("EXPIRED");
        } else if (record.getStatus() == null) {
            record.setStatus("VALID");
        }

        return credentialRepo.save(record);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord update) {

        CredentialRecord existing = credentialRepo.findById(id)
                .orElseThrow();

        if (update.getCredentialCode() != null)
            existing.setCredentialCode(update.getCredentialCode());

        if (update.getTitle() != null)
            existing.setTitle(update.getTitle());

        if (update.getIssuer() != null)
            existing.setIssuer(update.getIssuer());

        if (update.getCredentialType() != null)
            existing.setCredentialType(update.getCredentialType());

        return credentialRepo.save(existing);
    }

    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return credentialRepo.findByHolderId(holderId);
    }

    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return credentialRepo.findByCredentialCode(code)
                .orElse(null);
    }
}
