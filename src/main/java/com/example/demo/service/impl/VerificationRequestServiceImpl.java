package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {

    private final VerificationRequestRepository repository;

    public VerificationRequestServiceImpl(VerificationRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public VerificationRequest create(VerificationRequest request) {
        return repository.save(request);
    }

    @Override
    public List<VerificationRequest> getAll() {
        return repository.findAll();
    }

    @Override
    public List<VerificationRequest> getByCredentialId(Long credentialId) {
        return repository.findByCredentialId(credentialId);
    }
}
