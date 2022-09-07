package com.example.coron.controller;

import com.example.coron.request.ProductCreateRequest;
import com.example.coron.request.ProductUpdateRequest;
import com.example.coron.service.CategoryService;
import com.example.coron.service.ImageService;
import com.example.coron.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/admin/products")
    public String getBlogsPage(Model model) {
        model.addAttribute("products", productService.getAllProductDto());
        System.out.println(productService.getAllProductDto());
        return "admin/product/product-index";
    }


    @GetMapping("/admin/products/create")
    public String getCreateBlogPage(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "admin/product/product-create";
    }

    @GetMapping("/admin/products/{sku}")
    public String getDetailBlogsPage(@PathVariable String sku, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("product", productService.getProductDto(sku));
        model.addAttribute("images", imageService.getFiles("products",sku));
        return "admin/product/product-detail";
    }

    @PostMapping("/api/admin/products/create")
    @ResponseBody
    public void createProduct(@RequestBody ProductCreateRequest request){
        productService.create(request);
    }

    @PutMapping("/api/admin/products/{sku}")
    @ResponseBody
    public void updateProduct(@RequestBody ProductUpdateRequest request, @PathVariable String sku){
        productService.update(request, sku);
    }

    @DeleteMapping("/api/admin/products/{sku}")
    @ResponseBody
    public void deleteProduct(@PathVariable String sku){
        productService.delete(sku);
    }



}
