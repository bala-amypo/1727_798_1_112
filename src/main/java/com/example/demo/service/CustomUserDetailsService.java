package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: Load user from database
        // Example placeholder:
        // return new org.springframework.security.core.userdetails.User(
        //        "user", new BCryptPasswordEncoder().encode("password"), new ArrayList<>());
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
