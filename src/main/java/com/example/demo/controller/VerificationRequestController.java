package com.example.demo.controller;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verification-requests")
public class VerificationRequestController {
    
    @Autowired
    private VerificationRequestService verificationRequestService;
    
    @PostMapping
    public ResponseEntity<VerificationRequest> initiate(@RequestBody VerificationRequest request) {
        VerificationRequest initiatedRequest = verificationRequestService.initiateVerification(request);
        return ResponseEntity.ok(initiatedRequest);
    }
}