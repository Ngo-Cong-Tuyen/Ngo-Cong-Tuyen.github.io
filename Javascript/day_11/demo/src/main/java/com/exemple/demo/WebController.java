package com.exemple.demo;

// Controller + ResponseBody = RestController

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {
    private List<User> users = new ArrayList<>();

    public WebController(){
        users.add(new User(1,"Thang"));
        users.add(new User(2,"Khanh"));
        users.add(new User(3,"Tuyen"));
    }

    @RequestMapping(value = {"/","/users"}, method = RequestMethod.GET)
//    @ResponseBody
    public List<User> getUsers(){

        return users;
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(name = "id") int userId){
        for (User user: users) {
            if (user.getId()==userId){
                return user;
            }
        }
        return null;
    }

    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    public List<User> searchUser(@RequestParam String name) {
        System.out.println(name);
        return null;
    }

    @Re
}
