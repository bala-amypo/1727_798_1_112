package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialRecordController {

    private final CredentialRecordService credentialService;

    public CredentialRecordController(
            CredentialRecordService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping
    public CredentialRecord createCredential(
            @RequestBody CredentialRecord record) {
        return credentialService.createCredential(record);
    }

    @GetMapping("/{id}")
    public CredentialRecord getCredentialById(@PathVariable Long id) {
        return credentialService.getCredentialById(id);
    }

    @GetMapping
    public List<CredentialRecord> getAllCredentials() {
        return credentialService.getAllCredentials();
    }

    @DeleteMapping("/{id}")
    public void deleteCredential(@PathVariable Long id) {
        credentialService.deleteCredential(id);
    }
}
