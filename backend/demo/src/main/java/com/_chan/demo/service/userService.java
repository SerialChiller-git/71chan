package com._chan.demo.service;

import org.springframework.stereotype.Service;

import com._chan.demo.model.User;

@Service
public interface userService {
    User findByEmail(String email);
    User saveUser(User user);
}
