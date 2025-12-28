package com.example.demo.service;

import com.example.demo.entity.VerificationRule;
import java.util.List;

public interface VerificationRuleService {

    VerificationRule createRule(VerificationRule rule);

    // ✅ REQUIRED FOR VERIFICATION TESTS
    List<VerificationRule> getActiveRules();
}
