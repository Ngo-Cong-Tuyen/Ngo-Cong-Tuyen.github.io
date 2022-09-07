package com.example.coron.service;

import com.example.coron.entity.Category;
import com.example.coron.exception.NotFoundException;
import com.example.coron.repository.CategoryRepository;
import com.example.coron.request.CategoryCreateRequest;
import com.example.coron.request.CategoryUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public void create(CategoryCreateRequest request) {
        if (request.getCategoryId()!=null){
            Category category1 = Category.builder()
                    .name(request.getName())
                    .category(categoryRepository.findById(request.getCategoryId()).get())
                    .build();
            categoryRepository.save(category1);
        } else {
            Category category = Category.builder()
                    .name(request.getName())
                    .build();
            categoryRepository.save(category);
        }
    }


    public void update(CategoryUpdateRequest request, Integer id) {
        findById(id);
        if (request.getCategoryId()!=null){
            Category category1 = Category.builder()
                    .id(id)
                    .name(request.getName())
                    .category(categoryRepository.findById(request.getCategoryId()).get())
                    .build();
            categoryRepository.save(category1);
        } else {
            Category category2 = Category.builder()
                    .id(id)
                    .name(request.getName())
                    .build();
            categoryRepository.save(category2);
        }
    }

    public Category findById(Integer id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> {
            throw new NotFoundException("Not found category has id ="+id);
        });
        return category;
    }

    public void deleteById(Integer id) {
        Category category = findById(id);
        categoryRepository.delete(category);
    }
}
