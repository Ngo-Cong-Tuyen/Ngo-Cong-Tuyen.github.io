package com.example.coron.controller;

import com.example.coron.request.RegisterUserRequest;
import com.example.coron.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterUserRequest request){
        return authService.register(request);
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam String token){
        return authService.confirm(token);
    }

}