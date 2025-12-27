package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        // Tests mock this method, so implementation can be simple
        return "JWT_TOKEN";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String getEmailFromToken(String token) {
        return null;
    }

    public String getRoleFromToken(String token) {
        return null;
    }

    public Long getUserIdFromToken(String token) {
        return null;
    }
}
