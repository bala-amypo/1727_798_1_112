
// package com.example.demo.repository;

// import com.example.demo.entity.VerificationRule;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface VerificationRuleRepository
//         extends JpaRepository<VerificationRule, Long> {

//     List<VerificationRule> findByActiveTrue();
// }
package com.example.demo.repository;

import com.example.demo.entity.VerificationRule;
import java.util.List;

public interface VerificationRuleRepository {
    VerificationRule save(VerificationRule rule);
    List<VerificationRule> findByActiveTrue();
}
