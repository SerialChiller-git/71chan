package com._chan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._chan.demo.model.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/login")
    public String login() {
        return "Login successful";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // Here you would typically save the user to the database
        return "Registration successful";
    }
}
