package com.example.demo.service;

import com.example.demo.entity.VerificationRequest;

import java.util.List;

public interface VerificationRequestService {

    VerificationRequest createRequest(VerificationRequest request);

    VerificationRequest getRequestById(Long id);

    List<VerificationRequest> getAllRequests();

    VerificationRequest updateStatus(Long id, String status);
}
