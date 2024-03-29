package com.example.coron.service;

import com.example.coron.entity.User;
import com.example.coron.entity.Token;
import com.example.coron.exception.NotFoundException;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.repository.TokenRepository;
import com.example.coron.repository.UserRepository;
import com.example.coron.request.RegisterUserRequest;
import com.example.coron.request.ResetPasswordRequest;
import com.example.coron.security.UserDetailsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    @Autowired
    private UserService userService;


    public String register(RegisterUserRequest request) {
        // Lay ra thong tin user dua tren email
        boolean userExists = userRepository.findByEmail(request.getEmail()).isPresent();
        if(userExists) {
            return "Email has used";
        }
        String passwordEncode = passwordEncoder.encode(request.getPassword());

        User user = new User(request.getName(), request.getPhone(), request.getEmail(),passwordEncode,request.getAddress(),new ArrayList<>(List.of("USER")));
        userRepository.save(user);
        sendEmailToken(user,"confirm");
        return "Check your email to confirm token";
    }

    public void sendEmailToken(User user, String process) {
        String tokenString = UUID.randomUUID().toString();
        Token token = new Token(
                tokenString,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        tokenRepository.save(token);
        // Tạo link confirm
        String link = "http://localhost:8080/api/auth/"+process+"?token=" + tokenString;

        // Gửi email
        emailService.sendSimpleEmail(user.getEmail(), "Authenticate token",link);
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

    public boolean checkAccount(String email, String password){
        User user = userRepository.findByEmail(email).orElseThrow(()->{
            throw new NotFoundException("Not found user have email: " +email);
        });
        if (user.getPassword().equals(password)){
            return true;
        } else return false;
    }

    // Check user
    public String checkUser(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) return "anonymousUser";
        UserDetailsCustom user = (UserDetailsCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    public SimpleFeedback updateRoles(Integer userId, Boolean signal) {
        if (!checkAdmin().isValidate()){
            return checkAdmin();
        }
        return userService.changeRoleEditor(userId, signal);
    }

    public SimpleFeedback controllerAccount(Integer userId, boolean signal) {
        if (!checkAdmin().isValidate()){
            return checkAdmin();
        }
        return userService.controllerAccount(userId,signal);
    }
    public SimpleFeedback checkAdmin() {
        SimpleFeedback feedback = new SimpleFeedback();
        String adminEmail = checkUser();
        Object[] adminObject =  userService.findUserByEmail(adminEmail);
        SimpleFeedback findUserFeedback = (SimpleFeedback) adminObject[0];
        if (!findUserFeedback.isValidate()) {
            return findUserFeedback;
        }
        User admin = (User) adminObject[1];
        if (!admin.getRole().contains("ADMIN")) {
            feedback.setValidate(false);
            feedback.setMessage("Your account unauthorized");
            return feedback;
        }
        return feedback;
    }


    public String sendResetPassToken(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return "Email invalid";
        }
        sendEmailToken(user.get(),"reset-password");
        return "Successfully process";
    }

    public String resetPassword(ResetPasswordRequest request) {
        Optional<Token> token = tokenRepository.findByToken(request.getToken());
        if (token.isEmpty()){
            return "token not exist";
        }
        User user = token.get().getUser();
        String passwordEncode = passwordEncoder.encode(request.getPassword());
        user.setPassword(passwordEncode);
        userRepository.save(user);
        return "Successfully process";
    }
}



