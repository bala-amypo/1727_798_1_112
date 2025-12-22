package com.example.demo.controller;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/holders")
public class CredentialHolderController {
    
    @Autowired
    private CredentialHolderProfileService holderService;
    
    @PostMapping
    public ResponseEntity<CredentialHolderProfile> create(@RequestBody CredentialHolderProfile profile) {
        CredentialHolderProfile createdHolder = holderService.createHolder(profile);
        return ResponseEntity.ok(createdHolder);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CredentialHolderProfile> getById(@PathVariable Long id) {
        CredentialHolderProfile holder = holderService.getHolderById(id);
        return ResponseEntity.ok(holder);
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<CredentialHolderProfile> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        CredentialHolderProfile updatedHolder = holderService.updateStatus(id, active);
        return ResponseEntity.ok(updatedHolder);
    }
}