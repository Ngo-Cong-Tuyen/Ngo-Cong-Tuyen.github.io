package com.example.coron.dto;

import com.example.coron.entity.Amount;
import com.example.coron.entity.Category;
import com.example.coron.request.AmountRequest;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto implements Serializable {
    private String sku;
    private String name;
    private Integer price;
    private String content;
    private String description;
    private LocalDateTime createdAt;
    private List<CategoryDto> categories;
    private List<AmountDto> amounts;
    private List<ImageDto> images;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class CategoryDto implements Serializable {
        private Integer id;
        private String name;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class AmountDto implements Serializable {
        private Integer id;
        private String size;
        private String color;
        private Integer quantity;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class ImageDto implements Serializable {
        private Integer id;
        private String url;
    }
}
