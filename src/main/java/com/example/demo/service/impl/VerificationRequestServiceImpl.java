package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ REQUIRED
public class VerificationRequestServiceImpl
        implements VerificationRequestService {

    private final VerificationRequestRepository repository;

    public VerificationRequestServiceImpl(
            VerificationRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public VerificationRequest createRequest(VerificationRequest request) {
        request.setStatus("PENDING");
        return repository.save(request);
    }

    @Override
    public VerificationRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VerificationRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public VerificationRequest updateStatus(Long id, String status) {
        VerificationRequest request =
                repository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus(status);
            return repository.save(request);
        }
        return null;
    }
}
