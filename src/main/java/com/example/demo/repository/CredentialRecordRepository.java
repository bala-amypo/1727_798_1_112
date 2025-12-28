package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {

    CredentialRecord save(CredentialRecord record);

    Optional<CredentialRecord> findById(Long id);

    List<CredentialRecord> findByHolderId(Long holderId);

    Optional<CredentialRecord> findByCredentialCode(String credentialCode);

    // ✅ FIXED: Explicit JPQL
    @Query("select c from CredentialRecord c where c.expiryDate < :date")
    List<CredentialRecord> findExpiredBefore(@Param("date") LocalDate date);

    @Query("select c from CredentialRecord c where c.status = ?1")
    List<CredentialRecord> findByStatusUsingHql(String status);

    @Query("select c from CredentialRecord c where c.issuer = ?1 and c.credentialType = ?2")
    List<CredentialRecord> searchByIssuerAndType(String issuer, String credentialType);
}
