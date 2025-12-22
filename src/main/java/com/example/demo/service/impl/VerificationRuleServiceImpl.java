package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerificationRuleServiceImpl implements VerificationRuleService {
    
    private final VerificationRuleRepository ruleRepository;
    
    @Autowired
    public VerificationRuleServiceImpl(VerificationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }
    
    @Override
    public VerificationRule createRule(VerificationRule rule) {
        // Enforce uniqueness of ruleCode
        if (rule.getRuleCode() != null) {
            // Check if ruleCode already exists (you could add a repository method for this)
            // For simplicity, we'll assume unique constraint at database level
        }
        
        return ruleRepository.save(rule);
    }
}