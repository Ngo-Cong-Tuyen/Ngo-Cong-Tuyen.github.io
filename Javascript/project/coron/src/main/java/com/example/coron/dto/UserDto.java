package com.example.coron.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Boolean enabled;
    private List<String> role;
}
