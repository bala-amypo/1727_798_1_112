package com.example.demo.service.impl;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialHolderProfileServiceImpl {

    @Autowired
    private CredentialHolderProfileRepository profileRepository;

    public List<CredentialHolderProfile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public CredentialHolderProfile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CredentialHolderProfile not found with id: " + id));
    }

    public CredentialHolderProfile createProfile(CredentialHolderProfile profile) {
        return profileRepository.save(profile);
    }

    public CredentialHolderProfile updateProfile(Long id, CredentialHolderProfile profileDetails) {
        CredentialHolderProfile profile = getProfileById(id);
        profile.setName(profileDetails.getName());
        profile.setEmail(profileDetails.getEmail());
        // update other fields if needed
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        CredentialHolderProfile profile = getProfileById(id);
        profileRepository.delete(profile);
    }
}
