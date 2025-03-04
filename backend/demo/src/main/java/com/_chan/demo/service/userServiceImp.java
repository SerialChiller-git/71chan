package com._chan.demo.service;

import org.springframework.stereotype.Service;

import com._chan.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import com._chan.demo.model.User;

@Service
public class userServiceImp implements userService{
    private final userRepository UserRepository;
    private final PasswordEncoder passwordEncoder;
    @Lazy
    @Autowired
    public userServiceImp(userRepository UserRepository, PasswordEncoder passwordEncoder){
        this.UserRepository = UserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return UserRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return UserRepository.save(user);
    }
}
