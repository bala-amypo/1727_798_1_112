// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class VerificationRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String ruleCode;

//     private Boolean active;

//     public Long getId() {
//         return id;
//     }
 
//     public void setId(Long id) {
//         this.id = id;
//     }
 
//     public String getRuleCode() {
//         return ruleCode;
//     }
 
//     public void setRuleCode(String ruleCode) {
//         this.ruleCode = ruleCode;
//     }
 
//     public Boolean getActive() {
//         return active;
//     }
 
//     public void setActive(Boolean active) {
//         this.active = active;
//     }
// }


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.HashSet;
// import java.util.Set;

// @Entity
// @Table(name = "verification_rules")
// public class VerificationRule {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     private String ruleCode;
//     private String ruleName;
//     private String ruleDescription;
//     private String ruleLogic;
//     private Boolean active = true;
    
//     @ManyToMany(mappedBy = "rules")
//     private Set<CredentialRecord> credentials = new HashSet<>();
    
//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public String getRuleCode() { return ruleCode; }
//     public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    
//     public String getRuleName() { return ruleName; }
//     public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    
//     public String getRuleDescription() { return ruleDescription; }
//     public void setRuleDescription(String ruleDescription) { this.ruleDescription = ruleDescription; }
    
//     public String getRuleLogic() { return ruleLogic; }
//     public void setRuleLogic(String ruleLogic) { this.ruleLogic = ruleLogic; }
    
//     public Boolean getActive() { return active; }
//     public void setActive(Boolean active) { this.active = active; }
    
//     public Set<CredentialRecord> getCredentials() { return credentials; }
//     public void setCredentials(Set<CredentialRecord> credentials) { this.credentials = credentials; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class VerificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private Boolean active;

    public VerificationRule() {}

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
}
