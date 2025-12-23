// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.access.AccessDeniedHandler;
// import org.springframework.security.web.authentication.HttpStatusEntryPoint;
// import org.springframework.http.HttpStatus;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             // Disable CSRF for APIs
//             .csrf(csrf -> csrf.disable())

//             // No session (REST API)
//             .sessionManagement(session ->
//                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )

//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                     "/swagger-ui/**",
//                     "/v3/api-docs/**"
//                 ).hasRole("ADMIN")   
//                 .anyRequest().authenticated()
//             )

//             .httpBasic(httpBasic -> httpBasic.disable())
//             .formLogin(form -> form.disable())

//             .exceptionHandling(ex -> ex
//                 .authenticationEntryPoint(
//                     new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
//                 )
//                 .accessDeniedHandler(accessDeniedHandler())
//             );

//         return http.build();
//     }

//     @Bean
//     public AccessDeniedHandler accessDeniedHandler() {
//         return (request, response, accessDeniedException) -> {
//             response.setStatus(HttpStatus.FORBIDDEN.value());
//             response.getWriter().write("Access Denied");
//         };
//     }
// }
