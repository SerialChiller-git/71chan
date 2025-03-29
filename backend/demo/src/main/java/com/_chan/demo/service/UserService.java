package com._chan.demo.service;

import com._chan.demo.exceptions.UsernameAlreadyTakenException;
import com._chan.demo.model.RegistrationObject;
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
    public Optional<User> register(RegistrationObject ro){
        Optional<User> existingUser = userRepository.findByUsername(ro.getUsername());
        if(existingUser.isPresent()){
            throw new UsernameAlreadyTakenException();
        }
        User user = new User();
        user.setEmail(ro.getEmail());
        user.setUsername(ro.getUsername());
        user.setPassword(passEncoder.encode(ro.getPassword()));
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
