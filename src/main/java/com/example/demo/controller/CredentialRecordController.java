package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CredentialRecordController {

    private final CredentialRecordService service;

    public CredentialRecordController(CredentialRecordService service) {
        this.service = service;
    }

    public ResponseEntity<CredentialRecord> create(CredentialRecord r) {
        return ResponseEntity.ok(service.createCredential(r));
    }

    public ResponseEntity<CredentialRecord> update(Long id, CredentialRecord r) {
        return ResponseEntity.ok(service.updateCredential(id, r));
    }

    public ResponseEntity<List<CredentialRecord>> getByHolder(Long id) {
        return ResponseEntity.ok(service.getCredentialsByHolder(id));
    }

    public ResponseEntity<CredentialRecord> getByCode(String code) {
        return ResponseEntity.ok(service.getCredentialByCode(code));
    }
}
