package com.example.user.mapper;

import com.example.user.dto.UserDto;
import com.example.user.model.User;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatar(user.getAvatar())
                .build();
    }
}
