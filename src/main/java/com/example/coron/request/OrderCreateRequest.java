package com.example.coron.request;

import com.example.coron.entity.Shop;
import com.example.coron.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreateRequest {
    private String orderCode;
    private Integer shopId;
    private Integer userId;
    private List<Integer> carts;
    private Integer paymentTypeId;
    private String requiredNote;
    private Integer serviceTypeId;
    private Integer shipFee;
    private String expectedDeliveryTime;
}
