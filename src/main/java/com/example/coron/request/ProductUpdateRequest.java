package com.example.coron.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequest {
    private String sku;
    private String name;
    private Integer price;
    private String content;
    private String description;
    private List<Integer> categories;
    private List<AmountRequest> amounts;
}
