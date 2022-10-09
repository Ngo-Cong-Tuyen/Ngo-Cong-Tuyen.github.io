package com.example.coron.repository;

import com.example.coron.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> getByUser_Id(Integer id);

    Blog getById(Integer id);
}