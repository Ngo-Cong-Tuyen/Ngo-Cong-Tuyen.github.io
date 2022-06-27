package com.example.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// Dependece : ModelMapper, MapStruct
public class UserDto {
    private String username;
    private String email;
    private String avatar;
}
