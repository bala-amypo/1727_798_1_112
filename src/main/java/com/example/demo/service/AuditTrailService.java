// package com.example.demo.service;

// import com.example.demo.entity.AuditTrailRecord;
// import java.util.List;

// public interface AuditTrailService {
//     AuditTrailRecord saveRecord(AuditTrailRecord record);
//     List<AuditTrailRecord> getAllRecords();
//     AuditTrailRecord getRecordById(Long id);
// }
package com.example.demo.service;

import com.example.demo.entity.AuditTrailRecord;
import java.util.List;

public interface AuditTrailService {
    AuditTrailRecord logEvent(AuditTrailRecord record);
    List<AuditTrailRecord> getLogsByCredential(Long credentialId);
}
