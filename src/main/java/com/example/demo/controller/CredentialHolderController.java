package com.example.demo.controller;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holders")
@Tag(name = "Credential Holders")
public class CredentialHolderController {

    private final CredentialHolderProfileService service;

    public CredentialHolderController(CredentialHolderProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CredentialHolderProfile createHolder(@RequestBody CredentialHolderProfile profile) {
        return service.createHolder(profile);
    }

    @GetMapping("/{id}")
    public CredentialHolderProfile getHolder(@PathVariable Long id) {
        return service.getHolderById(id);
    }

    @GetMapping
    public List<CredentialHolderProfile> getAll() {
        return service.getAllHolders();
    }

    @PutMapping("/{id}/status")
    public CredentialHolderProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateHolderStatus(id, active);
    }
}
