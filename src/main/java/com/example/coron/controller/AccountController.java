package com.example.coron.controller;

import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.repository.UserRepository;
import com.example.coron.request.AccountRequest;
import com.example.coron.service.AuthService;
import com.example.coron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/my-account")
    public String getMyAccountPage(Model model) {
        String email = authService.checkUser();
        model.addAttribute("accountInfo",userService.getAccountInfo(email));
        return "web/my-account";
    }

    @PutMapping("api/v1/my-account/update")
    @ResponseBody
    public void updateAccount(@RequestBody AccountRequest request){
        String email = authService.checkUser();
        userService.updateAccount(email,request);
    }

    @GetMapping("/admin/users")
    public String getListUserPage(Model model){
        model.addAttribute("users", userService.getAllUserDto());
        return "/admin/user/list-user";
    }

    @PutMapping("/api/v2/admin/users/{id}/power")
    @ResponseBody
    public SimpleFeedback addEditor(@PathVariable Integer id){
        return authService.updateRoles(id, true);
    }

    @PutMapping("/api/v2/admin/users/{id}/lower")
    @ResponseBody
    public SimpleFeedback removeEditor(@PathVariable Integer id){
        return authService.updateRoles(id, false);
    }

    @PutMapping("/api/v2/admin/users/{id}/enable")
    @ResponseBody
    public SimpleFeedback enableAccount(@PathVariable Integer id){
        return authService.controllerAccount(id, true);
    }

    @PutMapping("/api/v2/admin/users/{id}/disable")
    @ResponseBody
    public SimpleFeedback disableAccount(@PathVariable Integer id){
        return authService.controllerAccount(id, false);
    }
}
