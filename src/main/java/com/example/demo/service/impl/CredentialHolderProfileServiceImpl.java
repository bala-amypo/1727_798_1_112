// package com.example.demo.service.impl;

// import com.example.demo.entity.CredentialHolderProfile;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.CredentialHolderProfileRepository;
// import com.example.demo.service.CredentialHolderProfileService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService {

//     @Autowired
//     private CredentialHolderProfileRepository repository;

//     @Override
//     public CredentialHolderProfile saveProfile(CredentialHolderProfile profile) {
//         return repository.save(profile);
//     }

//     @Override
//     public List<CredentialHolderProfile> getAllProfiles() {
//         return repository.findAll();
//     }

//     @Override
//     public CredentialHolderProfile getProfileById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id " + id));
//     }

//     @Override
//     public void deleteProfile(Long id) {
//         CredentialHolderProfile profile = getProfileById(id);
//         repository.delete(profile);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.service.CredentialHolderProfileService;

public class CredentialHolderProfileServiceImpl
        implements CredentialHolderProfileService {

    private final CredentialHolderProfileRepository repo;

    public CredentialHolderProfileServiceImpl(
            CredentialHolderProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public CredentialHolderProfile createHolder(CredentialHolderProfile profile) {
        return repo.save(profile);
    }

    @Override
    public CredentialHolderProfile getHolderById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holder not found"));
    }

    @Override
    public CredentialHolderProfile updateStatus(Long id, boolean active) {
        CredentialHolderProfile p = getHolderById(id);
        p.setActive(active);
        return repo.save(p);
    }
}
