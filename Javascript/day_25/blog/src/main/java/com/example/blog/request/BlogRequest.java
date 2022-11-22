package com.example.blog.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {
    private String title;
    private String content;
    private String description;
    private Integer status;
    private List<Integer> categories;
}
