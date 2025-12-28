package com.example.demo.controller;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AuditTrailController {

    private final AuditTrailService service;

    public AuditTrailController(AuditTrailService service) {
        this.service = service;
    }

    public ResponseEntity<AuditTrailRecord> log(AuditTrailRecord r) {
        return ResponseEntity.ok(service.logEvent(r));
    }

    public ResponseEntity<List<AuditTrailRecord>> getByCredential(Long id) {
        return ResponseEntity.ok(service.getLogsByCredential(id));
    }
}
