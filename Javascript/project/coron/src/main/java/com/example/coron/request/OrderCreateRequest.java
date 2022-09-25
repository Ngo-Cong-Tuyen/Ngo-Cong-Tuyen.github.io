package com.example.coron.request;

import com.example.coron.entity.Shop;
import com.example.coron.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private String order_code;
    private Integer shopId;
    private String userId;
    private List<Integer> carts;
    private Integer paymentTypeId;
    private String requiredNote;
    private Integer serviceTypeId;
    private Integer status;
    private Integer shipFee;
    private LocalDateTime expectedDeliveryTime;
}
