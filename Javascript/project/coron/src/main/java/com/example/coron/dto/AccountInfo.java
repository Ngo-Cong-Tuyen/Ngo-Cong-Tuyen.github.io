package com.example.coron.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo {
    private String name;
    private String phoneNumber;
    private String address;
}
