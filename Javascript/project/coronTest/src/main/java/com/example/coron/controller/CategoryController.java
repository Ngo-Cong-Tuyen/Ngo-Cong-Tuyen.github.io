package com.example.coron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("/admin/categories")
    public String getCategoryPage(Model model) {
        return "/admin/category/category-list";
    }
}
