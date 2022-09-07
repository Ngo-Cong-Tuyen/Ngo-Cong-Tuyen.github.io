package com.example.coron.repository;

import com.example.coron.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> getByIdIn(List<Integer> ids);
}