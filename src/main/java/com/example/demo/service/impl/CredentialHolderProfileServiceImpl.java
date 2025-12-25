package com.example.demo.service.impl;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.service.CredentialHolderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialHolderServiceImpl implements CredentialHolderService {

    private final CredentialHolderProfileRepository repository;

    public CredentialHolderServiceImpl(CredentialHolderProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CredentialHolderProfile create(CredentialHolderProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<CredentialHolderProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public CredentialHolderProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Credential Holder not found"));
    }
}
