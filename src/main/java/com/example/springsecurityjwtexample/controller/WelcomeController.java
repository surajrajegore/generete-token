package com.example.springsecurityjwtexample.controller;

import com.example.springsecurityjwtexample.dto.AuthRequest;
import com.example.springsecurityjwtexample.util.Jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private Jwtutil jwtutil;

    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/")
    public String welcome(){
        return "Welcome to the spring JWT example";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
        );
    }catch (Exception ex){
        throw new Exception("Invalid Username and password");
    }
        return jwtutil.generateToken(authRequest.getUserName());

        }
}
