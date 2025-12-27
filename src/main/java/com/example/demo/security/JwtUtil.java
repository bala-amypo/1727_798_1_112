package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component   // 🔑 REQUIRED
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        return "DUMMY_TOKEN";
    }
}
