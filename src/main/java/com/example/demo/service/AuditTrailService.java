package com.example.demo.service;

import com.example.demo.entity.AuditTrialRecord;
import java.util.List;

public interface AuditTrailService {

    AuditTrialRecord create(AuditTrialRecord record);

    List<AuditTrialRecord> getByCredentialId(Long credentialId);
}
