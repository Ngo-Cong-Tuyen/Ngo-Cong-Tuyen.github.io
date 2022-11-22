package com.example.coron.dto;

import com.example.coron.entity.User;
import com.example.coron.entity.Shop;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderHeaders {
    private Shop shop;
    private User user;
    private List<Integer> carts;
}
