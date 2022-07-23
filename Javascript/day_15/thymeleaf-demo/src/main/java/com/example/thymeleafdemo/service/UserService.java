package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users;

    public UserService(){
        users= new ArrayList<>();
        users.add(new User(1,"Nguyen Van A","a@gmail.com"));
        users.add(new User(2,"Tran Van B", "b@gmail.com"));
        users.add(new User(3,"Ngo Thi C", "c@gmail.com"));
    }

    public List<User> getUsers(){
        return users;
    }

    public User getUserById(int id) {
        for (User user: users){
            if(user.getId()== id){
                return user;
            }
        }
        return null;
    }
}
