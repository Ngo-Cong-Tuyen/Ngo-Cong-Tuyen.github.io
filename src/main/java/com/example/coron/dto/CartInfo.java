package com.example.coron.dto;

import lombok.*;

import javax.mail.search.IntegerComparisonTerm;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartInfo implements Serializable{
    private Integer userId;
    private Integer cartId;
    private Integer status;
    private String productName;
    private String sku;
    private Integer price;
    private Integer quantity;
    private String image;
    private LocalDateTime updatedAt;
}
