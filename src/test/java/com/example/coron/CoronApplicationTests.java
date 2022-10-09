package com.example.coron;

import com.example.coron.entity.User;
import com.example.coron.repository.CategoryRepository;
import com.example.coron.repository.UserRepository;
import com.example.coron.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class CoronApplicationTests {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
    }

    @Test
    void saveUser() {
        User user1 = User.builder()
                .name("Tuyen")
                .email("tuyen@gmail.com")
                .password(passwordEncoder.encode("111"))
                .enabled(true)
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

    @Test
    void getCategories() {
        System.out.println(categoryRepository.findAll());
    }

    @Test
    void getproducts() {
        System.out.println(productService.getAllProductDto());
    }

    @Test
    void testTime() {
        LocalDateTime dateTime = LocalDateTime.parse("2022-09-27T23:59:59Z", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(dateTime);
    }
}
