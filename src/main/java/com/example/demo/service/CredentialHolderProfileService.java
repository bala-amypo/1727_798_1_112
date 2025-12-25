package com.example.demo.service;

import com.example.demo.entity.CredentialHolderProfile;
import java.util.List;

public interface CredentialHolderProfileService {
    CredentialHolderProfile saveProfile(CredentialHolderProfile profile);
    List<CredentialHolderProfile> getAllProfiles();
    CredentialHolderProfile getProfileById(Long id);
    void deleteProfile(Long id);
}
