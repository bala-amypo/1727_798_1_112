package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationRequestServiceImpl {

    @Autowired
    private VerificationRequestRepository requestRepository;

    public List<VerificationRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public VerificationRequest getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VerificationRequest not found with id: " + id));
    }

    public VerificationRequest createRequest(VerificationRequest request) {
        return requestRepository.save(request);
    }

    public VerificationRequest updateRequest(Long id, VerificationRequest requestDetails) {
        VerificationRequest request = getRequestById(id);
        request.setStatus(requestDetails.getStatus());
        // update other fields if needed
        return requestRepository.save(request);
    }

    public void deleteRequest(Long id) {
        VerificationRequest request = getRequestById(id);
        requestRepository.delete(request);
    }
}
