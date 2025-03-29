package com._chan.demo.controller;

import com._chan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._chan.demo.exceptions.UsernameAlreadyTakenException;
import com._chan.demo.model.RegistrationObject;
import com._chan.demo.model.User;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService){
        this.userService = userService;
    }

    @ExceptionHandler(UsernameAlreadyTakenException.class)
    public ResponseEntity<String> handleUsernameAlreadyTakenException(UsernameAlreadyTakenException exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }

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
    public ResponseEntity<String> register(@RequestBody RegistrationObject ro) {
        try{

            userService.register(ro);
            return ResponseEntity.ok("User registered");
        }
        catch (RuntimeException exception){
            return ResponseEntity.badRequest().body(exception.toString());
        }

    }
}
