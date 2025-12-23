package com.example.demo.service.impl;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialHolderProfileServiceImpl
        implements CredentialHolderProfileService {

    @Autowired
    private CredentialHolderProfileRepository repository;

    @Override
    public CredentialHolderProfile createProfile(CredentialHolderProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<CredentialHolderProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public CredentialHolderProfile getProfileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CredentialHolderProfile updateProfile(
            Long id,
            CredentialHolderProfile profile) {

        Optional<CredentialHolderProfile> existing =
                repository.findById(id);

        if (existing.isPresent()) {
            CredentialHolderProfile profileDetails = existing.get();

            profileDetails.setFullName(profile.getFullName());
            profileDetails.setEmail(profile.getEmail());

            return repository.save(profileDetails);
        }

        return null;
    }

    @Override
    public void updateStatus(Long id, boolean active) {
        Optional<CredentialHolderProfile> existing =
                repository.findById(id);

        if (existing.isPresent()) {
            CredentialHolderProfile profile = existing.get();
            profile.setActive(active);
            repository.save(profile);
        }
    }

    @Override
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }
}
