package com.example.coron;

import com.example.coron.entity.User;
import com.example.coron.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class CoronApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
    }

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
