package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {

    List<CredentialRecord> findByHolderId(Long holderId);

    Optional<CredentialRecord> findByCredentialCode(String credentialCode);

    @Query("select c from CredentialRecord c where c.expiryDate < :date")
    List<CredentialRecord> findExpiredBefore(LocalDate date);

    @Query("select c from CredentialRecord c where c.status = :status")
    List<CredentialRecord> findByStatusUsingHql(String status);

    @Query("select c from CredentialRecord c where c.issuer = :issuer and c.credentialType = :type")
    List<CredentialRecord> searchByIssuerAndType(String issuer, String type);
}
