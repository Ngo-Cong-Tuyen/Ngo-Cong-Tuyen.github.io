package com.example.coron.controller;

import com.example.coron.request.AccountRequest;
import com.example.coron.service.AuthService;
import com.example.coron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class AccountController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

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
}
