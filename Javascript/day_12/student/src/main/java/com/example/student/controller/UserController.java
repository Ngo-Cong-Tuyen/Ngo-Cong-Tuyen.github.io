package com.example.student.controller;

import com.example.student.dto.UserDto;
import com.example.student.request.LoginRequest;
import com.example.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
//    @PostMapping("/login")
//    public UserDto login(@RequestBody LoginRequest request){
//        return userService.login(request);
//    }

//    MAc dinh du lieu nam trong body respone ko quan tam restController hay Controller
//    Ngoai ra su dung ResponeEntity co the them nhieu dinh dang cho respone.(img,..
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request){
        UserDto userDto = userService.login(request);
//        return ResponseEntity.ok(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
