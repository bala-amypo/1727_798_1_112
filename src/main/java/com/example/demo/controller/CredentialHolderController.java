package com.example.demo.controller;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.repository.CredentialHolderProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credential-holders")
public class CredentialHolderController {

    private final CredentialHolderProfileRepository repository;

    public CredentialHolderController(CredentialHolderProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public CredentialHolderProfile create(@RequestBody CredentialHolderProfile profile) {
        return repository.save(profile);
    }

    @GetMapping
    public List<CredentialHolderProfile> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public CredentialHolderProfile getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
