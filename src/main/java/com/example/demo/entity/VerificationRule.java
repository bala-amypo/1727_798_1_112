package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "verification_rules")
public class VerificationRule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "rule_code", nullable = false, unique = true)
    private String ruleCode;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @ManyToMany(mappedBy = "rules", fetch = FetchType.LAZY)
    private Set<CredentialRecord> credentials = new HashSet<>();
    
    public VerificationRule() {}
    
    public VerificationRule(String ruleCode, Boolean active) {
        this.ruleCode = ruleCode;
        this.active = active;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRuleCode() {
        return ruleCode;
    }
    
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public Set<CredentialRecord> getCredentials() {
        return credentials;
    }
    
    public void setCredentials(Set<CredentialRecord> credentials) {
        this.credentials = credentials;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerificationRule that = (VerificationRule) o;
        return Objects.equals(id, that.id) && 
               Objects.equals(ruleCode, that.ruleCode);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, ruleCode);
    }
    
    @Override
    public String toString() {
        return "VerificationRule{" +
                "id=" + id +
                ", ruleCode='" + ruleCode + '\'' +
                ", active=" + active +
                '}';
    }
}