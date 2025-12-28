package com.example.demo.controller;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/holders")
public class CredentialHolderController {

    private final CredentialHolderProfileService service;

    public CredentialHolderController(
            CredentialHolderProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CredentialHolderProfile create(
            @RequestBody CredentialHolderProfile profile) {
        return service.createHolder(profile);
    }

    @GetMapping("/{id}")
    public CredentialHolderProfile get(@PathVariable Long id) {
        return service.getHolderById(id);
    }
}
