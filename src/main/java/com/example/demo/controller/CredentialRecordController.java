package com.example.demo.controller;

import com.example.demo.config.OpenApiConfig;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credentials")
@SecurityRequirement(name = OpenApiConfig.SECURITY_SCHEME_NAME) // 🔒
public class CredentialRecordController {

    private final CredentialRecordService service;

    public CredentialRecordController(CredentialRecordService service) {
        this.service = service;
    }

    @PostMapping
    public CredentialRecord create(@RequestBody CredentialRecord record) {
        return service.createCredential(record);
    }

    @GetMapping("/holder/{holderId}")
    public List<CredentialRecord> byHolder(
            @PathVariable Long holderId) {
        return service.getCredentialsByHolder(holderId);
    }
}
