package com.example.demo.controller;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verification-requests")
public class VerificationRequestController {

    private final VerificationRequestService verificationRequestService;

    public VerificationRequestController(
            VerificationRequestService verificationRequestService) {
        this.verificationRequestService = verificationRequestService;
    }

    @PostMapping
    public VerificationRequest createRequest(
            @RequestBody VerificationRequest request) {
        return verificationRequestService.createRequest(request);
    }

    @GetMapping("/{id}")
    public VerificationRequest getRequestById(@PathVariable Long id) {
        return verificationRequestService.getRequestById(id);
    }

    @GetMapping
    public List<VerificationRequest> getAllRequests() {
        return verificationRequestService.getAllRequests();
    }

    @PutMapping("/{id}/status")
    public VerificationRequest updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return verificationRequestService.updateStatus(id, status);
    }
}
