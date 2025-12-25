// package com.example.demo.service.impl;

// import com.example.demo.entity.VerificationRule;
// import com.example.demo.repository.VerificationRuleRepository;
// import com.example.demo.service.VerificationRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class VerificationRuleServiceImpl implements VerificationRuleService {

//     private final VerificationRuleRepository repository;

//     public VerificationRuleServiceImpl(VerificationRuleRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public VerificationRule create(VerificationRule rule) {
//         return repository.save(rule);
//     }

//     @Override
//     public List<VerificationRule> getAll() {
//         return repository.findAll();
//     }

//     @Override
//     public List<VerificationRule> getActiveRules() {
//         return repository.findByActiveTrue();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;

public class VerificationRuleServiceImpl implements VerificationRuleService {

    private final VerificationRuleRepository repo;

    public VerificationRuleServiceImpl(VerificationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public VerificationRule createRule(VerificationRule rule) {
        return repo.save(rule);
    }
}
