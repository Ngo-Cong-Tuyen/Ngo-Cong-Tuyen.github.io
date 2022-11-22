package com.example.coron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @GetMapping("/admin/products")
    public String getBlogsPage(Model model) {
        return "admin/product/product-index";
    }


    @GetMapping("/admin/products/create")
    public String getCreateBlogPage(Model model) {
        return "admin/product/product-create";
    }

    @GetMapping("/admin/products/detail")
    public String getDetailBlogsPage() {
        return "admin/product/product-detail";
    }
}
