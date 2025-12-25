

// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final String SECRET = "secret123";
//     private final long EXPIRATION = 86400000;

//     public String generateToken(String email) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                 .signWith(SignatureAlgorithm.HS256, SECRET)
//                 .compact();
//     }

//     public String extractEmail(String token) {
//         return Jwts.parser()
//                 .setSigningKey(SECRET)
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getSubject();
//     }
// }

// package com.example.demo.security;

// public class JwtUtil {
//     public String generateToken(Long userId, String email, String role) {
//         return "DUMMY_TOKEN";
//     }
// }
package com.example.demo.security;

public class JwtUtil {
    public String generateToken(Long userId, String email, String role) {
        return "DUMMY_TOKEN";
    }
}
