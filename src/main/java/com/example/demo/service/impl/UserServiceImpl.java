package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ REQUIRED BY TEST (DO NOT REMOVE)
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {

        // ❌ Duplicate email → BadRequestException
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException();
        }

        // ✅ Encode password (_ENC in tests)
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // ✅ Save and return saved entity
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {

        // ❌ Not found → ResourceNotFoundException
        return userRepository.findByEmail(email)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
