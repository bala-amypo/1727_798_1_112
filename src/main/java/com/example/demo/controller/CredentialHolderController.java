package com.example.demo.controller;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holders")
public class CredentialHolderController {

    private final CredentialHolderProfileService holderService;

    public CredentialHolderController(
            CredentialHolderProfileService holderService) {
        this.holderService = holderService;
    }

    @PostMapping
    public CredentialHolderProfile createHolder(
            @RequestBody CredentialHolderProfile profile) {
        return holderService.createHolder(profile);
    }

    @GetMapping("/{id}")
    public CredentialHolderProfile getHolderById(@PathVariable Long id) {
        return holderService.getHolderById(id);
    }

    @GetMapping
    public List<CredentialHolderProfile> getAllHolders() {
        return holderService.getAllHolders();
    }

    @PutMapping("/{id}")
    public CredentialHolderProfile updateHolder(
            @PathVariable Long id,
            @RequestBody CredentialHolderProfile profile) {
        return holderService.updateHolder(id, profile);
    }

    @DeleteMapping("/{id}")
    public void deleteHolder(@PathVariable Long id) {
        holderService.deleteHolder(id);
    }
}
