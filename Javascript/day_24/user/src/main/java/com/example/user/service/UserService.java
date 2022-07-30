package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.exception.BadRequestException;
import com.example.user.exception.NotFoundException;
import com.example.user.mapper.UserMapper;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.request.CreateUserRequest;
import com.example.user.request.UpdateAvatarRequest;
import com.example.user.request.UserPasswordRequest;
import com.example.user.request.UserRequest;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private UserRepository userRepository;


    // Lay danh sach User
    public List<UserDto> getUsers(){
//        ModelMapper modelMapper = new ModelMapper();
//        return userRepository.findAll()
//                .stream()
//                .map(user -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());
         return userRepository.getAllUserDto();
    }

    //Tim kiem user theo ten
    public List<UserDto> searchUser(String name) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    //Xoa user by id
    public void deleteUser(int id){
        // Kiem tra xem user co ton tai hay ko
        if (userRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Khong ton tai user co id = "+id);
        }
        // Xoa user
        userRepository.deleteById(id);
    }

    // Lay user theo id
    public UserDto getUserById(int id) {
        return UserMapper.toUserDto(userRepository.findById(id).orElseThrow(()->{
        throw new NotFoundException("Khong ton tai user co id = "+id);
        }));
    }



    public boolean updatePassWord(int id, UserPasswordRequest userPasswordRequest) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Khong ton tai user co id = "+id);
        });
        if (user.getPassword().equals(userPasswordRequest.getPassword())){
            user.setPassword(userPasswordRequest.getNewPassword());
            return true;
        } else return false;
    }

    public UserDto updateUser(int id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(()->{
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
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException("Khong ton tai user co id = "+id);
        }
        Random rd = new Random();
        String pass= String.valueOf(rd.nextInt(100,999));
        userRepository.findById(id).get().setPassword(pass);
        emailService.sendSimpleEmail("tuyenemotion@gmail.com", "Quen mat khau",pass);
        return  pass;
    }


    public UserDto createUser(CreateUserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new BadRequestException("Email bi trung");
        }
        Random rd = new Random();
        User user = new User(rd.nextInt(100),request.getName(), request.getEmail(), request.getPhone(), request.getAddress(),null,request.getPassword());
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }


    public String uploadFile(int id, MultipartFile file){
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException("Khong ton tai user co id = "+id);
        }
        // upload file
        return fileService.uploadFile(id,file);
    }

    public byte[] readFile(int id, String fileId){
        return fileService.readFile(id, fileId);
    }

    public String uploadAvatar(int id, MultipartFile file) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Khong ton tai user co id = "+id);
        });

        String filePath =uploadFile(id, file);

        user.setAvatar(filePath);
        userRepository.save(user);
        return filePath;
    }

    public List<String> getFiles(int id) {
        return fileService.getFiles(id);
    }

    public void deleteFile(int id, String fileId) {
        fileService.deleteFile(id,fileId);
    }

    public String updateAvatar(int id, UpdateAvatarRequest request) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Khong ton tai user co id = "+id);
        });
        user.setAvatar(request.getAvatar());
        return user.getAvatar();
    }
}
