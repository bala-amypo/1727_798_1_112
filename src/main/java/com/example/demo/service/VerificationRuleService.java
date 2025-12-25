// package com.example.demo.service;

// import com.example.demo.entity.VerificationRule;
// import java.util.List;

// public interface VerificationRuleService {

//     VerificationRule create(VerificationRule rule);

//     List<VerificationRule> getAll();

//     List<VerificationRule> getActiveRules();
// }
package com.example.demo.service;

import com.example.demo.entity.VerificationRule;

public interface VerificationRuleService {
    VerificationRule createRule(VerificationRule rule);
}
