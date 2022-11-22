package com.example.demo_security;

import com.example.demo_security.entity.User;
import com.example.demo_security.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class DemoSecurityApplicationTests {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Test
    void saveUser() {
       User user1 = User.builder()
               .name("Tuyen")
               .email("tuyen@gmail.com")
               .password(passwordEncoder.encode("111"))
               .role(List.of("USER","EDITOR","ADMIN"))
               .build();

       User user2 = User.builder()
                .name("Thang")
                .email("thang@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role(List.of("USER","EDITOR"))
                .build();

       User user3 = User.builder()
                .name("Khanh")
                .email("khanh@gmail.com")
                .password(passwordEncoder.encode("111"))
                .role(List.of("USER"))
                .build();

       userRepository.saveAll(List.of(user1,user2,user3));
    }

}
