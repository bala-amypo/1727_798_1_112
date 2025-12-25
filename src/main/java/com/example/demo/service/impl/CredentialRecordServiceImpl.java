// package com.example.demo.service.impl;

// import com.example.demo.entity.CredentialRecord;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.CredentialRecordRepository;
// import com.example.demo.service.CredentialRecordService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CredentialRecordServiceImpl implements CredentialRecordService {

//     @Autowired
//     private CredentialRecordRepository repository;

//     @Override
//     public CredentialRecord saveRecord(CredentialRecord record) {
//         return repository.save(record);
//     }

//     @Override
//     public List<CredentialRecord> getAllRecords() {
//         return repository.findAll();
//     }

//     @Override
//     public CredentialRecord getRecordById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Credential record not found with id " + id));
//     }

//     @Override
//     public void deleteRecord(Long id) {
//         CredentialRecord record = getRecordById(id);
//         repository.delete(record);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;

import java.time.LocalDate;
import java.util.List;

public class CredentialRecordServiceImpl implements CredentialRecordService {

    private final CredentialRecordRepository repo;

    public CredentialRecordServiceImpl(CredentialRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public CredentialRecord createCredential(CredentialRecord record) {
        if (record.getExpiryDate() != null &&
                record.getExpiryDate().isBefore(LocalDate.now())) {
            record.setStatus("EXPIRED");
        } else if (record.getStatus() == null) {
            record.setStatus("VALID");
        }
        return repo.save(record);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord update) {
        CredentialRecord existing = repo.findById(id).orElseThrow();
        existing.setCredentialCode(update.getCredentialCode());
        return repo.save(existing);
    }

    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return repo.findByHolderId(holderId);
    }

    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return repo.findByCredentialCode(code).orElse(null);
    }
}
