package com.example.coron.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WishlistInfo {
    private String sku;
    private String image;
    private String productName;
    private Integer price;
    private Integer stockStatus;
}
