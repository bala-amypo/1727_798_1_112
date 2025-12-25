package com.example.demo.controller;

import com.example.demo.entity.AuditTrialRecord;
import com.example.demo.repository.AuditTrialRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-trails")
public class AuditTrailController {

    private final AuditTrialRecordRepository repository;

    public AuditTrailController(AuditTrialRecordRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public AuditTrialRecord create(@RequestBody AuditTrialRecord record) {
        return repository.save(record);
    }

    @GetMapping("/credential/{credentialId}")
    public List<AuditTrialRecord> getByCredentialId(@PathVariable Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }
}
