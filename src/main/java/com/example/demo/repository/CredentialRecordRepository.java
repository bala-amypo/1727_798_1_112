package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {

    // REQUIRED BY TEST
    List<CredentialRecord> findExpiredBefore(LocalDate date);

    // REQUIRED BY TEST (must use @Query)
    @Query("SELECT c FROM CredentialRecord c WHERE c.status = :status")
    List<CredentialRecord> findByStatusUsingHql(String status);

    // REQUIRED BY TEST (must use @Query)
    @Query("SELECT c FROM CredentialRecord c WHERE c.issuer = :issuer AND c.credentialType = :type")
    List<CredentialRecord> searchByIssuerAndType(String issuer, String type);

    // REQUIRED BY TEST
    List<CredentialRecord> findByHolderId(Long holderId);

    // REQUIRED BY TEST
    CredentialRecord findByCredentialCode(String code);
}
