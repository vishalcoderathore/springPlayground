package com.learnspring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnspring.demo.model.User;
import com.learnspring.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByUsernameAndPassword(String username, String password){
        if("admin".equals(username) && "password".equals(password)){
            return new User("admin", "password");
        }
        return null;
    }
}