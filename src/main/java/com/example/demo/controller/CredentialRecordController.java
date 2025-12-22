package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credentials")
public class CredentialRecordController {
    
    @Autowired
    private CredentialRecordService credentialService;
    
    @PostMapping
    public ResponseEntity<CredentialRecord> create(@RequestBody CredentialRecord record) {
        CredentialRecord createdCredential = credentialService.createCredential(record);
        return ResponseEntity.ok(createdCredential);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CredentialRecord> update(
            @PathVariable Long id,
            @RequestBody CredentialRecord update) {
        CredentialRecord updatedCredential = credentialService.updateCredential(id, update);
        return ResponseEntity.ok(updatedCredential);
    }
    
    @GetMapping("/holder/{holderId}")
    public ResponseEntity<List<CredentialRecord>> getByHolder(@PathVariable Long holderId) {
        List<CredentialRecord> credentials = credentialService.getCredentialsByHolder(holderId);
        return ResponseEntity.ok(credentials);
    }
    
    @GetMapping("/code/{code}")
    public ResponseEntity<CredentialRecord> getByCode(@PathVariable String code) {
        CredentialRecord credential = credentialService.getCredentialByCode(code);
        if (credential == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(credential);
    }
}