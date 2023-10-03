package com.learnboot.mywebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        return username.equalsIgnoreCase("vishal") && password.equals("pswd");
    }
}
