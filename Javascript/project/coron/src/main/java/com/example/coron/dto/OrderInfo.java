package com.example.coron.dto;

import com.example.coron.entity.Shop;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class OrderInfo implements Serializable{
    private Integer id;
    private String orderCode;
    private Shop shop;
    private UserDto receiver;
    private Integer paymentTypeId;
    private String requiredNote;
    private Integer serviceTypeId;
    private List<CartInfo> cartInfos;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class UserDto implements Serializable {
        private Integer id;
        private String name;
    }
}

