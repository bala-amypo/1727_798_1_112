// package com.example.demo.controller;

// import com.example.demo.entity.VerificationRequest;
// import com.example.demo.repository.VerificationRequestRepository;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/verification-requests")
// public class VerificationRequestController {

//     private final VerificationRequestRepository repository;

//     public VerificationRequestController(VerificationRequestRepository repository) {
//         this.repository = repository;
//     }

//     @PostMapping
//     public VerificationRequest create(@RequestBody VerificationRequest request) {
//         return repository.save(request);
//     }

//     @GetMapping
//     public List<VerificationRequest> getAll() {
//         return repository.findAll();
//     }

//     @GetMapping("/credential/{credentialId}")
//     public List<VerificationRequest> getByCredentialId(@PathVariable Long credentialId) {
//         return repository.findByCredentialId(credentialId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import org.springframework.http.ResponseEntity;

public class VerificationRequestController {

    private final VerificationRequestService service;

    public VerificationRequestController(VerificationRequestService service) {
        this.service = service;
    }

    public ResponseEntity<VerificationRequest> initiate(VerificationRequest request) {
        return ResponseEntity.ok(service.initiateVerification(request));
    }
}
