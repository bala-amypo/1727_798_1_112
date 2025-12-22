package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.SimplePasswordEncoder;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final SimplePasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, SimplePasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Duplicate email");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }
}
