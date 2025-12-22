package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CredentialHolderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String organization;
    private Boolean active;

    // getters and setters
}
