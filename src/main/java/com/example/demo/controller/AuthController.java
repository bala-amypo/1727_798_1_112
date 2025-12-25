// package com.example.demo.controller;

// import com.example.demo.dto.*;
// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtUtil;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final UserRepository userRepo;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserRepository userRepo, JwtUtil jwtUtil) {
//         this.userRepo = userRepo;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody RegisterRequest req) {
//         User u = new User();
//         u.setFullName(req.getFullName());
//         u.setEmail(req.getEmail());
//         u.setPassword(req.getPassword());
//         return userRepo.save(u);
//     }

//     @PostMapping("/login")
//     public JwtResponse login(@RequestBody LoginRequest req) {
//         return new JwtResponse(jwtUtil.generateToken(req.getEmail()));
//     }
// }
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
        if (req.getEmail() == null)
            throw new BadRequestException("Invalid");

        User user = new User(null,
                req.getFullName(),
                req.getEmail(),
                req.getPassword(),
                req.getRole());

        User saved = userService.registerUser(user);

        String token = jwtUtil.generateToken(
                saved.getId(),
                saved.getEmail(),
                saved.getRole());

        return ResponseEntity.ok(
                new JwtResponse(token, saved.getId(),
                        saved.getEmail(), saved.getRole()));
    }

    public ResponseEntity<JwtResponse> login(LoginRequest req) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(), req.getPassword()));

        User user = userService.findByEmail(req.getEmail());

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole());

        return ResponseEntity.ok(
                new JwtResponse(token, user.getId(),
                        user.getEmail(), user.getRole()));
    }
}
