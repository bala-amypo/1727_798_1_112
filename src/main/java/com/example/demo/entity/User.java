package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role = "VIEWER";
    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
}
