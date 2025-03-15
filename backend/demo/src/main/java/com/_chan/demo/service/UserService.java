package com._chan.demo.service;

import com._chan.demo.model.User;
import com._chan.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    public Optional<User> register(User user){
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser.isPresent()){
            throw new RuntimeException("User already exists!");
        }
        user.setPassword(passEncoder.encode(user.getPassword()));
        return Optional.of(userRepository.save(user));
    }
    public Optional<User> login(User user){
        Optional<User> userToLogin = userRepository.findByUsername(user.getUsername());
        if(userToLogin.isPresent()){
            boolean credentials = passEncoder.matches(user.getPassword(), userToLogin.get().getPassword());
            if(credentials){
                return userToLogin;
            }
            throw new RuntimeException("Wrong password");
        }
        throw new RuntimeException("User does not exist");
    }
}
