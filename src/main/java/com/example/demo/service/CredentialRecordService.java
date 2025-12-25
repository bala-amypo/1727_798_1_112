package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {
    CredentialRecord saveRecord(CredentialRecord record);
    List<CredentialRecord> getAllRecords();
    CredentialRecord getRecordById(Long id);
    void deleteRecord(Long id);
}
