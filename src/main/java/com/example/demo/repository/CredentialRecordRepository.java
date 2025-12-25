
// package com.example.demo.repository;

// import com.example.demo.entity.CredentialRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

// public interface CredentialRecordRepository
//         extends JpaRepository<CredentialRecord, Long> {

//     List<CredentialRecord> findByHolderId(Long holderId);

//     Optional<CredentialRecord> findByCredentialCode(String credentialCode);

//     List<CredentialRecord> findByExpiryDateBefore(LocalDate date);

//     List<CredentialRecord> findByStatus(String status);

//     List<CredentialRecord> findByIssuerAndCredentialType(String issuer, String credentialType);
// }
package com.example.demo.repository;

import com.example.demo.entity.CredentialRecord;
import java.time.LocalDate;
import java.util.*;

public interface CredentialRecordRepository {

    CredentialRecord save(CredentialRecord record);

    Optional<CredentialRecord> findById(Long id);

    List<CredentialRecord> findByHolderId(Long holderId);

    Optional<CredentialRecord> findByCredentialCode(String credentialCode);

    List<CredentialRecord> findExpiredBefore(LocalDate date);

    List<CredentialRecord> findByStatusUsingHql(String status);

    List<CredentialRecord> searchByIssuerAndType(String issuer, String credentialType);

    // Needed for verification tests
    List<CredentialRecord> findAll();
}
