// package com.example.demo.repository;

// import com.example.demo.entity.CredentialRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface CredentialRecordRepository
//         extends JpaRepository<CredentialRecord, Long> {
// }

package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CredentialRecordRepository
        extends JpaRepository<CredentialRecord, Long> {

    List<CredentialRecord> findByHolderId(Long holderId);

    Optional<CredentialRecord> findByCredentialCode(String credentialCode);

    List<CredentialRecord> findByExpiryDateBefore(LocalDate date);

    List<CredentialRecord> findByStatus(String status);

    List<CredentialRecord> findByIssuerAndCredentialType(String issuer, String credentialType);
}
