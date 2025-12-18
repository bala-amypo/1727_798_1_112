package com.example.demo.controller;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verification")
@Tag(name = "Verification Requests")
public class VerificationRequestController {

    private final VerificationRequestService service;

    public VerificationRequestController(VerificationRequestService service) {
        this.service = service;
    }

    @PostMapping
    public VerificationRequest initiate(@RequestBody VerificationRequest request) {
        return service.initiateVerification(request);
    }

    @PutMapping("/{id}/process")
    public VerificationRequest process(@PathVariable Long id) {
        return service.processVerification(id);
    }

    @GetMapping("/credential/{credentialId}")
    public List<VerificationRequest> getByCredential(
            @PathVariable Long credentialId) {
        return service.getRequestsByCredential(credentialId);
    }

    @GetMapping
    public List<VerificationRequest> getAll() {
        return service.getAllRequests();
    }
}
