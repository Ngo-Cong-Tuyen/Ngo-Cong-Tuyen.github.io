package com.example.coron.controller;

import com.example.coron.request.LoginRequest;
import com.example.coron.request.RegisterUserRequest;
import com.example.coron.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest request, HttpSession session) {
        // Tạo đối tượng xác thực dựa trên thông tin request
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        // Tiến hành xác thực
        Authentication authentication = authenticationManager.authenticate(token);

        // Lưu trữ thông tin của đối tượng đã đăng nhập
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Lưu thông tin vào trong session
        session.setAttribute("MY_SESSION", authentication.getName());
    }



}