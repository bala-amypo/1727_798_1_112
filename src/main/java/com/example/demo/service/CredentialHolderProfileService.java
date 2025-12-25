package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {

    CredentialRecord create(CredentialRecord record);

    List<CredentialRecord> getAll();

    CredentialRecord getById(Long id);
}
