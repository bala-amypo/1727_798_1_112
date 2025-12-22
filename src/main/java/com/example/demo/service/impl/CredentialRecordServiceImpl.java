package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CredentialRecordServiceImpl implements CredentialRecordService {
    
    private final CredentialRecordRepository credentialRepository;
    
    @Autowired
    public CredentialRecordServiceImpl(CredentialRecordRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }
    
    @Override
    public CredentialRecord createCredential(CredentialRecord record) {
        // Check if credential code already exists
        if (record.getCredentialCode() != null && 
            credentialRepository.findByCredentialCode(record.getCredentialCode()).isPresent()) {
            throw new IllegalArgumentException("Credential code already exists: " + record.getCredentialCode());
        }
        
        // Validate metadata JSON
        if (record.getMetadataJson() != null && !record.getMetadataJson().startsWith("{")) {
            throw new IllegalArgumentException("Metadata JSON must start with '{'");
        }
        
        // Handle expiry and status
        if (record.getExpiryDate() != null && record.getExpiryDate().isBefore(LocalDate.now())) {
            record.setStatus("EXPIRED");
        } else if (record.getStatus() == null) {
            record.setStatus("VALID");
        }
        
        return credentialRepository.save(record);
    }
    
    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord update) {
        CredentialRecord existing = credentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CredentialRecord", "id", id));
        
        // Update updatable fields
        if (update.getCredentialCode() != null) {
            existing.setCredentialCode(update.getCredentialCode());
        }
        if (update.getTitle() != null) {
            existing.setTitle(update.getTitle());
        }
        if (update.getIssuer() != null) {
            existing.setIssuer(update.getIssuer());
        }
        if (update.getCredentialType() != null) {
            existing.setCredentialType(update.getCredentialType());
        }
        if (update.getExpiryDate() != null) {
            existing.setExpiryDate(update.getExpiryDate());
            // Update status based on new expiry date
            if (update.getExpiryDate().isBefore(LocalDate.now())) {
                existing.setStatus("EXPIRED");
            }
        }
        if (update.getStatus() != null) {
            existing.setStatus(update.getStatus());
        }
        if (update.getMetadataJson() != null) {
            if (!update.getMetadataJson().startsWith("{")) {
                throw new IllegalArgumentException("Metadata JSON must start with '{'");
            }
            existing.setMetadataJson(update.getMetadataJson());
        }
        
        return credentialRepository.save(existing);
    }
    
    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return credentialRepository.findByHolderId(holderId);
    }
    
    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return credentialRepository.findByCredentialCode(code)
                .orElse(null); // Return null when not found as per requirements
    }
}