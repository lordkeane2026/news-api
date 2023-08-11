package com.tonykeane.newsapi.controllers;

import com.tonykeane.newsapi.entity.ApplicationUser;
import com.tonykeane.newsapi.models.LoginResponse;
import com.tonykeane.newsapi.models.RegistrationRequest;
import com.tonykeane.newsapi.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationRequest request) {
        return authenticationService.registerUser(request.getUsername(), request.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody RegistrationRequest body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
