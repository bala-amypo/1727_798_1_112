package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class CredentialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long holderId;
    private String credentialCode;
    private String title;
    private String issuer;
    private String credentialType;
    private String status;
    private LocalDate expiryDate;
    private String metadataJson;

    @ManyToMany
    private Set<VerificationRule> rules;

    // getters and setters
}
