package com.example.demo.controller;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-trails")
public class AuditTrailController {
    
    @Autowired
    private AuditTrailService auditTrailService;
    
    @PostMapping
    public ResponseEntity<AuditTrailRecord> log(@RequestBody AuditTrailRecord record) {
        AuditTrailRecord loggedRecord = auditTrailService.logEvent(record);
        return ResponseEntity.ok(loggedRecord);
    }
    
    @GetMapping("/credential/{credentialId}")
    public ResponseEntity<List<AuditTrailRecord>> getByCredential(@PathVariable Long credentialId) {
        List<AuditTrailRecord> auditLogs = auditTrailService.getLogsByCredential(credentialId);
        return ResponseEntity.ok(auditLogs);
    }
}