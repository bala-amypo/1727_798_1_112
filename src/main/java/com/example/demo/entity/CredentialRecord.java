package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "credentialCode"))
public class CredentialRecord {

    @Id @GeneratedValue
    private Long id;

    private Long holderId;
    private String credentialCode;
    private String title;
    private String issuer;
    private LocalDate issuedDate;
    private LocalDate expiryDate;
    private String credentialType;
    private String status = "VALID";

    @Lob
    private String metadataJson;

    @ManyToMany
    private Set<VerificationRule> rules;

    // getters & setters
}
