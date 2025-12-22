package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialRecordServiceImpl {

    @Autowired
    private CredentialRecordRepository recordRepository;

    public List<CredentialRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public CredentialRecord getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CredentialRecord not found with id: " + id));
    }

    public CredentialRecord createRecord(CredentialRecord record) {
        return recordRepository.save(record);
    }

    public CredentialRecord updateRecord(Long id, CredentialRecord recordDetails) {
        CredentialRecord record = getRecordById(id);
        record.setTitle(recordDetails.getTitle());
        record.setDescription(recordDetails.getDescription());
        // update other fields if needed
        return recordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        CredentialRecord record = getRecordById(id);
        recordRepository.delete(record);
    }
}
