package com.example.coron.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopCreateRequest {
    private String token;
    private String shopId;
    private String name;
    private String address;
}
