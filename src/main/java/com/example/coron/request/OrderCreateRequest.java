package com.example.coron.request;

import lombok.*;

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
