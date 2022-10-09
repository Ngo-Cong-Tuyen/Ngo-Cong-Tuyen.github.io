package com.example.coron.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListCartInfo implements Serializable {
    private Integer userId;
    private String userName;
    private String phone;
    private String address;
    private List<CartInfo> cartInfos;
}
