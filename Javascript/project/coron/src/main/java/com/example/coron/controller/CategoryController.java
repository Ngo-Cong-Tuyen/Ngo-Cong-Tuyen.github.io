package com.example.coron.controller;

import com.example.coron.request.CategoryCreateRequest;
import com.example.coron.request.CategoryUpdateRequest;
import com.example.coron.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categories")
    public String getCategoryPage(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "/admin/category/category-list";
    }

    @PostMapping("/api/admin/categories/create")
    @ResponseBody
    public void CreateNewCategory(@RequestBody CategoryCreateRequest request) {
        categoryService.create(request);
    }

    @PutMapping("/api/admin/categories/{id}/update")
    @ResponseBody
    public void UpdateCategory(@RequestBody CategoryUpdateRequest request, @PathVariable Integer id) {
        categoryService.update(request, id);
    }

    @DeleteMapping("/api/admin/categories/{id}/delete")
    @ResponseBody
    public void DeleteCategory(@PathVariable Integer id){
        categoryService.deleteById(id);
    }
}
