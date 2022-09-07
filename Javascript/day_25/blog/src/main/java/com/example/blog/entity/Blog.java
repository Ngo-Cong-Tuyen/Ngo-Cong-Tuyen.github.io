package com.example.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "slug")
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "published_at")
    private LocalDateTime published_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "blog_categories",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categories = new LinkedHashSet<>();

    @PrePersist
    public void prePersist() {
        created_at = LocalDateTime.now();
        if (status ==1) {
            published_at = created_at;
        }

    }

    @PreUpdate
    public void preUpdate() {
        updated_at = LocalDateTime.now();
        if (status ==1) {
            published_at = updated_at;
        }
    }
}