// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenUtil {

//     private final String jwtSecret = "SecretKey12345"; // Change this to your secret
//     private final long jwtExpirationMs = 86400000; // 1 day

//     // Generate token
//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     // Validate token
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     // Get username from token
//     public String getUsernameFromToken(String token) {
//         Claims claims = Jwts.parser()
//                 .setSigningKey(jwtSecret)
//                 .parseClaimsJws(token)
//                 .getBody();
//         return claims.getSubject();
//     }
// }


package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
    
    public String generateToken(Long userId, String email, String role) {
        // Simplified token generation for testing
        return "jwt_token_" + userId + "_" + email + "_" + role;
    }
    
    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt_token_");
    }
    
    public Long getUserIdFromToken(String token) {
        if (token == null) return null;
        String[] parts = token.split("_");
        return parts.length > 2 ? Long.parseLong(parts[2]) : null;
    }
    
    public String getEmailFromToken(String token) {
        if (token == null) return null;
        String[] parts = token.split("_");
        return parts.length > 3 ? parts[3] : null;
    }
    
    public String getRoleFromToken(String token) {
        if (token == null) return null;
        String[] parts = token.split("_");
        return parts.length > 4 ? parts[4] : null;
    }
}