// package com.example.demo.security;

// import java.util.Base64;

// public class SimplePasswordEncoder {

//     public String encode(String rawPassword) {
//         return Base64.getEncoder().encodeToString(rawPassword.getBytes());
//     }

//     public boolean matches(String rawPassword, String encodedPassword) {
//         return encode(rawPassword).equals(encodedPassword);
//     }
// }
package com.example.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class SimplePasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            return null;
        }
        return Base64.getEncoder()
                .encodeToString(rawPassword.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null || encodedPassword == null) {
            return false;
        }
        String encodedRawPassword = encode(rawPassword);
        return encodedRawPassword.equals(encodedPassword);
    }
}
