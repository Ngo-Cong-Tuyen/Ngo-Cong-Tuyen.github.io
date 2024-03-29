package com.example.coron.repository;

import com.example.coron.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> getByIdIn(List<Integer> ids);
}