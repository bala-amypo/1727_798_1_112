// package com.example.demo.service;

// import com.example.demo.entity.CredentialRecord;
// import java.util.List;

// public interface CredentialRecordService {
//     CredentialRecord saveRecord(CredentialRecord record);
//     List<CredentialRecord> getAllRecords();
//     CredentialRecord getRecordById(Long id);
//     void deleteRecord(Long id);
// }
package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {
    CredentialRecord createCredential(CredentialRecord record);
    CredentialRecord updateCredential(Long id, CredentialRecord update);
    List<CredentialRecord> getCredentialsByHolder(Long holderId);
    CredentialRecord getCredentialByCode(String code);
}
