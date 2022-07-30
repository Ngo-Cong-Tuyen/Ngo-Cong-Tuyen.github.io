package com.example.user.controller;

import com.example.user.dto.UserDto;
import com.example.user.request.CreateUserRequest;
import com.example.user.request.UpdateAvatarRequest;
import com.example.user.request.UserPasswordRequest;
import com.example.user.request.UserRequest;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {


    @Autowired
    private UserService userService;

    // Lay danh sach user
    // http://localhost:8080/api/v1/users
    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    // Lay danh sach user theo ten
    // http://localhost:8080/api/v1/users
    @GetMapping("/users/search")
    public List<UserDto> searchUsers(@RequestParam String name){
        return userService.searchUser(name);
    }

    // Xoa by id
    // http://localhost:8080/api/v1/users
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable int id){
        userService.deleteUser(id);
    }

    // Lay user theo id
    // http://localhost:8080/api/v1/users
    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("users/check/{id}")
    public boolean updatePassWord(@PathVariable int id,@RequestBody UserPasswordRequest userPasswordRequest){
        return userService.updatePassWord(id,userPasswordRequest);
    }

    @PutMapping("users/{id}")
    public UserDto updateUser(@PathVariable int id,@RequestBody UserRequest userRequest){
        return userService.updateUser(id,userRequest);
    }

    @PostMapping("users/{id}/forgot-password")
    public String forgotPassword(@PathVariable int id){
        return  userService.forgotPassword(id);
    }

    @PostMapping("users")
    public UserDto createUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    // Cap nhat avatar
    @PostMapping("/users/{id}/upload-avatar")
    public String uploadAvatar(@PathVariable int id, @ModelAttribute("file") MultipartFile file){
        return userService.uploadAvatar(id, file);
    }
    // Upload file
    @PostMapping("/users/{id}/files")
    public String uploadFile(@PathVariable int id, @ModelAttribute("file") MultipartFile file){
        return userService.uploadFile(id, file);
    }
    /// Xem file
    @GetMapping(value = "users/{id}/files/{fileId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] readFile(@PathVariable int id,@PathVariable String fileId){
        return userService.readFile(id, fileId);
    }

    // LAy danh sach file
    @GetMapping("/users/{id}/files")
    public List<String> getFiles(@PathVariable int id){
        return userService.getFiles(id);
    }

    //Xoa file
    @DeleteMapping("/users/{id}/files/{fileId}")
    public void deleteFile(@PathVariable int id, @PathVariable String fileId){
         userService.deleteFile(id,fileId);
    }

    @PutMapping("/users/{id}/update-avatar")
    public String updateFile(@PathVariable int id, @RequestBody UpdateAvatarRequest request){
        return userService.updateAvatar(id, request);
    }

}
