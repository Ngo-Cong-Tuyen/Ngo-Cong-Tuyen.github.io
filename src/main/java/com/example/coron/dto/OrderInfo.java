package com.example.coron.dto;

import com.example.coron.entity.Shop;
import com.example.coron.entity.User;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderInfo implements Serializable{
    private Integer id;
    private String orderCode;
    private ShopDto shop;
    private UserDto receiver;
    private Integer paymentTypeId;
    private String requiredNote;
    private Integer serviceTypeId;
    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer shipFee;
    private LocalDateTime expectedDeliveryTime;
    private LocalDateTime deliveryTime;
    private List<CartInfo> carts;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class ShopDto implements Serializable {
        private Integer id;
        private Integer shopId;
        private String name;
    }

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

