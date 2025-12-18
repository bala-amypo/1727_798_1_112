package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ruleCode"))
public class VerificationRule {

    @Id @GeneratedValue
    private Long id;

    private String ruleCode;
    private String description;
    private String appliesToType;
    private String validationExpression;
    private Boolean active = true;

    // getters & setters
}
