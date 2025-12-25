package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credentials")
public class CredentialRecordController {

    private final CredentialRecordRepository repository;

    public CredentialRecordController(CredentialRecordRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public CredentialRecord create(@RequestBody CredentialRecord record) {
        return repository.save(record);
    }

    @GetMapping
    public List<CredentialRecord> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public CredentialRecord getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
