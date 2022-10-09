package com.example.coron.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReviewInfo {
    private String content;
    private Integer rating;
    private String time;
    private String username;
}
