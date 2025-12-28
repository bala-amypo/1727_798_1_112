package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialRecordController {

    private final CredentialRecordService service;

    public CredentialRecordController(
            CredentialRecordService service) {
        this.service = service;
    }

    @PostMapping
    public CredentialRecord create(
            @RequestBody CredentialRecord record) {
        return service.createCredential(record);
    }

    @GetMapping("/holder/{holderId}")
    public List<CredentialRecord> byHolder(
            @PathVariable Long holderId) {
        return service.getCredentialsByHolder(holderId);
    }
}
