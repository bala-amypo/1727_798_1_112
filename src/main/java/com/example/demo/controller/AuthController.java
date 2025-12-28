package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;

public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<JwtResponse> register(RegisterRequest req) {
        User user = new User();
        user.setFullName(req.getFullName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());

        User saved = userService.registerUser(user);

        String token = jwtUtil.generateToken(
                saved.getId(), saved.getEmail(), saved.getRole());

        return ResponseEntity.ok(
                new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole()));
    }

    public ResponseEntity<JwtResponse> login(LoginRequest req) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(), req.getPassword()));

        User user = userService.findByEmail(req.getEmail());

        String token = jwtUtil.generateToken(
                user.getId(), user.getEmail(), user.getRole());

        return ResponseEntity.ok(
                new JwtResponse(token, user.getId(), user.getEmail(), user.getRole()));
    }
}
