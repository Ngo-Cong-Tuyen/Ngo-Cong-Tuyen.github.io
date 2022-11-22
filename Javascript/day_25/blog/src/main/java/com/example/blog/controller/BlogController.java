package com.example.blog.controller;

import com.example.blog.request.BlogRequest;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/blogs")
    public String getBlogsPage(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogDto());
        return "admin/blog/blog-index";
    }

    @GetMapping("/admin/blogs/own-blogs")
    public String getOwnBlogsPage(Model model) {
        // Todo: thay the id can tim
        Integer userId = 1;
        model.addAttribute("blogs", blogService.getAllBlogDtoByUserId(userId));
        return "admin/blog/blog-yourself";
    }

    @GetMapping("/admin/blogs/create")
    public String getCreateBlogPage(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "admin/blog/blog-create";
    }

    @GetMapping("/admin/blogs/{id}/detail")
    public String getDetailBlogsPage(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        model.addAttribute("categories", categoryService.getAll());
        return "admin/blog/blog-detail";
    }

    @PostMapping("/admin/blogs/create")
    @ResponseBody
    public void createBlog(@RequestBody BlogRequest request) {
        blogService.createBlog(request);
    }

    @PutMapping("/admin/blogs/{id}/detail")
    @ResponseBody
    public void updateBlog(@RequestBody BlogRequest request, @PathVariable Integer id) {
        blogService.updateBlog(request, id);
    }

    @DeleteMapping("/admin/blogs/{id}")
    @ResponseBody
    public void deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlogById(id);
    }
}
