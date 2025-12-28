package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 🔐 SECRET KEY (minimum 256 bits for HS256)
    private static final Key KEY =
            Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // ⏱ Token validity (1 hour)
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;

    // ===============================
    // ✅ TOKEN GENERATION
    // ===============================
    public String generateToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(KEY)
                .compact();
    }

    // ===============================
    // ✅ TOKEN VALIDATION
    // ===============================
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // ===============================
    // ✅ EXTRACT EMAIL
    // ===============================
    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    // ===============================
    // ✅ EXTRACT USER ID
    // ===============================
    public Long getUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    // ===============================
    // ✅ EXTRACT ROLE
    // ===============================
    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ===============================
    // 🔒 INTERNAL CLAIM PARSER
    // ===============================
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
