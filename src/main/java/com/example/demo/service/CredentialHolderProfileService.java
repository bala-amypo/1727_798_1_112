package com.example.demo.service;

import com.example.demo.entity.CredentialHolderProfile;

import java.util.List;

public interface CredentialHolderProfileService {

    CredentialHolderProfile createHolder(CredentialHolderProfile profile);

    CredentialHolderProfile getHolderById(Long id);

    List<CredentialHolderProfile> getAllHolders();

    CredentialHolderProfile updateHolder(Long id, CredentialHolderProfile profile);

    void deleteHolder(Long id);
}
