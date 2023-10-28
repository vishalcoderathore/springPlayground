package com.learnspring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.demo.model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody User user) {
        User userFound = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (userFound != null) {
            return ResponseEntity.ok().body("Login successfull");
        }

        return ResponseEntity.status(401).body("Invalid credentials");

    }
}
