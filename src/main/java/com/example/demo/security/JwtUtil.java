package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        return "TOKEN_" + userId + "_" + role;
    }
}
