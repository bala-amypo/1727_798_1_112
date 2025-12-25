package com.example.demo.controller;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditTrailController {

    @Autowired
    private AuditTrailRecordRepository auditRepo;

    @GetMapping
    public List<AuditTrailRecord> getAllAuditRecords() {
        return auditRepo.findAll();
    }

    @PostMapping
    public AuditTrailRecord createAuditRecord(@RequestBody AuditTrailRecord record) {
        return auditRepo.save(record);
    }
}
