package com.example.course;

import com.example.course.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    void contextLoads() {
        System.out.println(userRepo.getAll());
    }

}
