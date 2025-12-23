package com.example.demo.service.impl;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialHolderProfileServiceImpl
        implements CredentialHolderProfileService {

    private final CredentialHolderProfileRepository repository;

    public CredentialHolderProfileServiceImpl(
            CredentialHolderProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CredentialHolderProfile createHolder(CredentialHolderProfile profile) {
        return repository.save(profile);
    }

    @Override
    public CredentialHolderProfile getHolderById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CredentialHolderProfile> getAllHolders() {
        return repository.findAll();
    }

    @Override
    public CredentialHolderProfile updateHolder(Long id, CredentialHolderProfile profile) {
        CredentialHolderProfile existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(profile.getName());
        existing.setEmail(profile.getEmail());
        return repository.save(existing);
    }

    @Override
    public void deleteHolder(Long id) {
        repository.deleteById(id);
    }
}
