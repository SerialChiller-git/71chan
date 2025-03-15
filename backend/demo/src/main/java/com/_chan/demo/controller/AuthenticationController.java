package com._chan.demo.controller;

import com._chan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._chan.demo.model.User;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public ResponseEntity<String> login(User user) {
        try{
            userService.login(user);
            return ResponseEntity.ok("Login good");
        }
        catch(RuntimeException exception){
            return ResponseEntity.badRequest().body(exception.toString());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try{
            userService.register(user);
            return ResponseEntity.ok("User registered");
        }
        catch (RuntimeException exception){
            return ResponseEntity.badRequest().body(exception.toString());
        }

    }
}
