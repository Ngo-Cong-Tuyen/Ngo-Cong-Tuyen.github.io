package com.example.coron.controller;

import com.example.coron.request.BlogRequest;
import com.example.coron.service.BlogService;
import com.example.coron.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
     // Render data in admin/blogs, get all blogs information.
    @GetMapping("/admin/blogs")
    public String getBlogsPage(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogDto());
        return "admin/blog/blog-index";
    }

    // Get the blogs of an admin by email.
    @GetMapping("/admin/blogs/own-blogs")
    public String getOwnBlogsPage(Model model) {
        // Todo: thay the id can tim
        Integer userId = 1;
        model.addAttribute("blogs", blogService.getAllBlogDtoByUserId(userId));
        return "admin/blog/blog-yourself";
    }

    // create url to create blog
    @GetMapping("admin/blogs/create")
    public String getCreateBlogPage(Model model) {
        return "admin/blog/blog-create";
    }

    // Create url detail page and transfer blogs information by id
    @GetMapping("api/admin/blogs/{id}/detail")
    public String getDetailBlogsPage(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        model.addAttribute("tags", tagService.getAll());
        return "admin/blog/blog-detail";
    }

    // Create a blog
    @PostMapping("api/admin/blogs/create")
    @ResponseBody
    public void createBlog(@RequestBody BlogRequest request) {
        blogService.createBlog(request);
    }

    // Update a blog
    @PutMapping("api/admin/blogs/{id}/detail")
    @ResponseBody
    public void updateBlog(@RequestBody BlogRequest request, @PathVariable Integer id) {
        blogService.updateBlog(request, id);
    }

    // Delete a blog
    @DeleteMapping("api/admin/blogs/{id}")
    @ResponseBody
    public void deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlogById(id);
    }


}
