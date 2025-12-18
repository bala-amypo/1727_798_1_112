package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ruleCode"))
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;
    private String appliesToType;
    private String validationExpression;
    private Boolean active = true;

    // Default constructor
    public VerificationRule() {}

    // Parameterized constructor
    public VerificationRule(
            String ruleCode,
            String description,
            String appliesToType,
            String validationExpression) {

        this.ruleCode = ruleCode;
        this.description = description;
        this.appliesToType = appliesToType;
        this.validationExpression = validationExpression;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAppliesToType() { return appliesToType; }
    public void setAppliesToType(String appliesToType) { this.appliesToType = appliesToType; }

    public String getValidationExpression() { return validationExpression; }
    public void setValidationExpression(String validationExpression) {
        this.validationExpression = validationExpression;
    }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
