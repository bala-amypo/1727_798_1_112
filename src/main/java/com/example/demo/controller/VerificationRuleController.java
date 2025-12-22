package com.example.demo.controller;

import com.example.demo.entity.VerificationRule;
import com.example.demo.service.VerificationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class VerificationRuleController {
    
    @Autowired
    private VerificationRuleService ruleService;
    
    @PostMapping
    public ResponseEntity<VerificationRule> create(@RequestBody VerificationRule rule) {
        VerificationRule createdRule = ruleService.createRule(rule);
        return ResponseEntity.ok(createdRule);
    }
}