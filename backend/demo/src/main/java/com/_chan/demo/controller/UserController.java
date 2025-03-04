package com._chan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._chan.demo.service.userService;
import com._chan.demo.model.User;

@RestController


@RequestMapping("/api")
public class UserController {
    private final userService UserService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(userService UserService, PasswordEncoder passwordEncoder) {
        this.UserService = UserService;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User existingUser = UserService.findByEmail(user.getEmail());
        User existingUserName = UserService.findByEmail(user.getUsername());
        if (existingUser != null) {
            return "Email already exists";
        }
        if (existingUserName != null){
            return "Username already exists";
        }
        UserService.saveUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = UserService.findByEmail(user.getEmail());
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    
}
