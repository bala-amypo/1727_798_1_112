package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // ❌ Disable CSRF (Swagger uses GET)
            .csrf(csrf -> csrf.disable())

            // ❌ Disable default login page
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // ✅ Authorization rules
            .authorizeHttpRequests(auth -> auth
                // ✅ Swagger URLs
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // ✅ Auth APIs
                .requestMatchers(
                    "/auth/login",
                    "/auth/register"
                ).permitAll()

                // 🔒 Everything else secured
                .anyRequest().authenticated()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
