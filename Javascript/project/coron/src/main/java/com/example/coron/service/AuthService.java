package com.example.coron.service;

import com.example.coron.entity.Token;
import com.example.coron.entity.User;
import com.example.coron.repository.TokenRepository;
import com.example.coron.repository.UserRepository;
import com.example.coron.request.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public String register(RegisterUserRequest request) {
        // Lay ra thong tin user dua tren email
        boolean userExists = userRepository.findByEmail(request.getEmail()).isPresent();
        if(userExists) {
            throw new RuntimeException("Email ko tom tai");
        }
        String passwordEncode = passwordEncoder.encode(request.getPassword());

        User user = new User(request.getName(), request.getPhone(), request.getEmail(),passwordEncode,request.getAddress(),new ArrayList<>(List.of("USER")));
        userRepository.save(user);

        String tokenString = UUID.randomUUID().toString();
        Token token = new Token(
                tokenString,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        tokenRepository.save(token);
        // Tạo link confirm
        String link = "http://localhost:8080/api/auth/confirm?token=" + tokenString;

        // Gửi email (về nhà làm)
        emailService.sendSimpleEmail("tuyenemotion@gmail.com", "Authenticate token",link);
        return link;
    }

    public String confirm(String tokenString) {
        // Lay ra thong tin token
        Token token = tokenRepository.findByToken(tokenString).orElseThrow(()->{
            throw new RuntimeException("Token ko ton tai");
        });

        if (token.getConfirmedAt()!=null){
            throw new RuntimeException("Token da dc kich hoat");
        };

        LocalDateTime expiredAt = token.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token da het han");
        }

        // Active token
        tokenRepository.activeToken(tokenString, LocalDateTime.now());
        // Active user
        userRepository.activeUser(token.getUser().getEmail());

        return "confirm";
    }
}



