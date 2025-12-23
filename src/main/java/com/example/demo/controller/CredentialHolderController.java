package com.example.demo.controller;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holders")
public class CredentialHolderController {

    @Autowired
    private CredentialHolderProfileService holderService;

    // CREATE
    @PostMapping
    public ResponseEntity<CredentialHolderProfile> createProfile(
            @RequestBody CredentialHolderProfile profile) {

        return ResponseEntity.ok(
                holderService.createProfile(profile)
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<CredentialHolderProfile>> getAllProfiles() {
        return ResponseEntity.ok(
                holderService.getAllProfiles()
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CredentialHolderProfile> getProfileById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                holderService.getProfileById(id)
        );
    }

    // UPDATE PROFILE
    @PutMapping("/{id}")
    public ResponseEntity<CredentialHolderProfile> updateProfile(
            @PathVariable Long id,
            @RequestBody CredentialHolderProfile profile) {

        return ResponseEntity.ok(
                holderService.updateProfile(id, profile)
        );
    }

    // UPDATE STATUS (void → ResponseEntity)
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        holderService.updateStatus(id, active);
        return ResponseEntity.ok("Status updated successfully");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfile(
            @PathVariable Long id) {

        holderService.deleteProfile(id);
        return ResponseEntity.ok("Profile deleted successfully");
    }
}
