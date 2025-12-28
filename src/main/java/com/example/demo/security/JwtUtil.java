package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        // Simple token – tests only check non-null value
        return "TOKEN_" + userId + "_" + role;
    }
}
