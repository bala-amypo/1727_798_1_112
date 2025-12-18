package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "holderId"),
        @UniqueConstraint(columnNames = "email")
})
public class CredentialHolderProfile {

    @Id @GeneratedValue
    private Long id;

    private String holderId;
    private String fullName;
    private String email;
    private String organization;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
}
