package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {
}
