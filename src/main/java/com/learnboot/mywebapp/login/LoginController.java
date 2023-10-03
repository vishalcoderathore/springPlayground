package com.learnboot.mywebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    public LoginController(AuthenticationService authService) {
        this.authService = authService;
    }

    private AuthenticationService authService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (authService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }
        model.put("error", "Invalid Credentials"); 
        return "login";
    }
}
