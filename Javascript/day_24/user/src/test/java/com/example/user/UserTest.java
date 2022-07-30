package com.example.user;

import com.example.user.dto.UserDto;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserTest {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @Test
    void saveAllUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(1,"Nguyen Van A","a@gmail.com","0986366716",
                "Tỉnh Thái Bình",null,"111"));

        users.add(new User(2,"Nguyen Van B","b@gmail.com","0986366716",
                "Tỉnh Nam Định",null,"222"));
        users.add(new User(3,"Nguyen Van C","c@gmail.com","0986366716",
                "Thành phố Hà Nội",null,"333"));
        users.add(new User(4,"Nguyen Van D","d@gmail.com","0986366716",
                "Thành Phố Hồ Chí Minh",null,"444"));

        userRepository.saveAll(users);
    }

    @Test
    void get_all_user_using_model_mapper_test() {
        List<UserDto> userDtos = userService.getUsers();
        userDtos.forEach(System.out::println);
    }
}
