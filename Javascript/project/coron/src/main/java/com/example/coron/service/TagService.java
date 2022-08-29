package com.example.coron.service;

import com.example.coron.entity.Tag;
import com.example.coron.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }
}
