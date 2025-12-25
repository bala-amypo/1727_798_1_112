// package com.example.demo.service.impl;

// import com.example.demo.entity.AuditTrailRecord;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.AuditTrailRecordRepository;
// import com.example.demo.service.AuditTrailService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class AuditTrailServiceImpl implements AuditTrailService {

//     @Autowired
//     private AuditTrailRecordRepository repository;

//     @Override
//     public AuditTrailRecord saveRecord(AuditTrailRecord record) {
//         return repository.save(record);
//     }

//     @Override
//     public List<AuditTrailRecord> getAllRecords() {
//         return repository.findAll();
//     }

//     @Override
//     public AuditTrailRecord getRecordById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Audit record not found with id " + id));
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import com.example.demo.service.AuditTrailService;

import java.time.LocalDateTime;
import java.util.List;

public class AuditTrailServiceImpl implements AuditTrailService {

    private final AuditTrailRecordRepository repo;

    public AuditTrailServiceImpl(AuditTrailRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public AuditTrailRecord logEvent(AuditTrailRecord record) {
        if (record.getLoggedAt() == null) {
            record.setLoggedAt(LocalDateTime.now());
        }
        return repo.save(record);
    }

    @Override
    public List<AuditTrailRecord> getLogsByCredential(Long credentialId) {
        return repo.findByCredentialId(credentialId);
    }
}
