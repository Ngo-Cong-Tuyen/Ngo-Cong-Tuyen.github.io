package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.exception.BadRequestException;
import com.example.user.exception.NotFoundException;
import com.example.user.mapper.UserMapper;
import com.example.user.model.User;
import com.example.user.request.CreateUserRequest;
import com.example.user.request.UserPasswordRequest;
import com.example.user.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> users;
    @Autowired
    private EmailService emailService;
    @Autowired
    private FileService fileService;


    public UserService() {
        users = new ArrayList<>();
        users.add(new User(1,"Nguyen Van A","a@gmail.com","0986366716",
                "Tỉnh Thái Bình",null,"111"));

        users.add(new User(2,"Nguyen Van B","b@gmail.com","0986366716",
                "Tỉnh Nam Định",null,"222"));
        users.add(new User(3,"Nguyen Van C","c@gmail.com","0986366716",
                "Thành phố Hà Nội",null,"333"));
        users.add(new User(4,"Nguyen Van D","d@gmail.com","0986366716",
                "Thành Phố Hồ Chí Minh",null,"444"));
    }

    // Lay danh sach User
    public List<UserDto> getUsers(){
        return users.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }

    //Tim kiem user theo ten
    public List<UserDto> searchUser(String name) {
        return users
                .stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    //Xoa user by id
    public void deleteUser(int id){
        // Kiem tra xem user co ton tai hay ko
        Optional<User> userOptional = findUserById(id);
        if (userOptional.isEmpty()) {
            throw new NotFoundException("Khong ton tai user co id = "+id);
        }
        // Xoa user
        users.removeIf(user -> user.getId()==id);
    }

    // Lay user theo id
    public UserDto getUserById(int id) {
        return UserMapper.toUserDto(findUserById(id).orElseThrow(()->{
        throw new NotFoundException("Khong ton tai user co id = "+id);
        }));
    }
    public Optional<User> findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst();
    }


    public boolean updatePassWord(int id, UserPasswordRequest userPasswordRequest) {
        User user = findUserById(id).orElseThrow(()->{
            throw new NotFoundException("Khong ton tai user co id = "+id);
        });
        if (user.getPassword().equals(userPasswordRequest.getPassword())){
            user.setPassword(userPasswordRequest.getNewPassword());
            return true;
        } else return false;
    }

    public UserDto updateUser(int id, UserRequest userRequest) {
        User user = findUserById(id).orElseThrow(()->{
            throw new NotFoundException("Khong ton tai user co id = "+id);
        });
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .address(userRequest.getAddress())
                .avatar(userRequest.getAvatar())
                .build();

        return userDto;
    }

    public String forgotPassword(int id) {
        if (findUserById(id).isEmpty()){
            throw new NotFoundException("Khong ton tai user co id = "+id);
        }
        Random rd = new Random();
        String pass= String.valueOf(rd.nextInt(100,999));
        findUserById(id).get().setPassword(pass);
        emailService.sendSimpleEmail("tuyenemotion@gmail.com", "Quen mat khau",pass);
        return  pass;
    }


    public UserDto createUser(CreateUserRequest request) {
        if (findUserByEmail(request.getEmail()).isPresent()){
            throw new BadRequestException("Email bi trung");
        }
        Random rd = new Random();
        User user = new User(rd.nextInt(100),request.getName(), request.getEmail(), request.getPhone(), request.getAddress(),null,request.getPassword());
        users.add(user);
        return UserMapper.toUserDto(user);
    }

    public Optional<User> findUserByEmail(String email){
       return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public String uploadFile(int id, MultipartFile file){
        if (findUserById(id).isEmpty()){
            throw new NotFoundException("Khong ton tai user co id = "+id);
        }
        // upload file
        return fileService.uploadFile(id,file);
    }

    public byte[] readFile(int id, String fileId){
        return fileService.readFile(id, fileId);
    }

    public String uploadAvatar(int id, MultipartFile file) {
        Optional<User> userOptional = findUserById(id);
        if (userOptional.isEmpty()){
            throw new NotFoundException("Ko tim thay file co id =" +id);
        }

        User user = userOptional.get();

        String filePath =uploadFile(id, file);

        user.setAvatar(filePath);
        return filePath;
    }

    public List<String> getFiles(int id) {
        return fileService.getFiles(id);
    }

    public void deleteFile(int id, String fileId) {
        fileService.deleteFile(id,fileId);
    }
}
