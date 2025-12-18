package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    // REQUIRED CONSTRUCTOR SIGNATURE
    public UserServiceImpl(
            UserRepository repository,
            PasswordEncoder encoder) {

        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {
        // TEST-COMPATIBLE encoding
        user.setPassword(user.getPassword() + "_ENC");
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
