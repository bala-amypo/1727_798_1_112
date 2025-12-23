package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;

import java.util.List;

public interface CredentialRecordService {

    CredentialRecord createCredential(CredentialRecord record);

    CredentialRecord getCredentialById(Long id);

    List<CredentialRecord> getAllCredentials();

    void deleteCredential(Long id);
}
