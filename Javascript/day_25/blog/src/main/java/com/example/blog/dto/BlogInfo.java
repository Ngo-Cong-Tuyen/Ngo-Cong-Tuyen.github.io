package com.example.blog.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BlogInfo {
    private Integer id;
    private String title;
    private String slug;
    private String description;
    private String content;
    private String thumbnail;
    private String publishedAt;
    private Integer countComment;
    private AuthorInfo authorInfo;

    public BlogInfo(Integer id, String title, String slug, String description, String content, String thumbnail, String publishedAt, Integer countComment, String authorInfo) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.content = content;
        this.thumbnail = thumbnail;
        this.publishedAt = publishedAt;
        this.countComment = countComment;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.authorInfo = objectMapper.readValue(authorInfo, AuthorInfo.class);
        }catch (Exception e) {
            this.authorInfo=null;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class AuthorInfo {
        private Integer id;
        private String name;
    }


}
