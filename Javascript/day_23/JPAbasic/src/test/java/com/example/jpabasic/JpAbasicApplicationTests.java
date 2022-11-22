package com.example.jpabasic;

import com.example.jpabasic.entity.User;
import com.example.jpabasic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpAbasicApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    void save_method_test(){
        User user = User.builder()
                .name("tuyen")
                .age(24)
                .status(true)
                .build();

        userService.saveUser(user);
    }
}
