package com.example.blog.controller;

import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.CategoryRepository;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private BlogService blogService;


    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BlogRepository blogRepository;


    @GetMapping("/")
    public String getHome(Model model, @RequestParam(required = false, defaultValue = "a") String p) {
        System.out.println(p);
        model.addAttribute("blogs", blogRepository.getAllBlogInfo("%a%"));
        model.addAttribute("rencentsPost", blogService.getRecentBLog());
        model.addAttribute("categories", categoryRepository.findAll());
        return "web/index";
    }

    @GetMapping("/blogs/{id}/{slug}")
    public String getDetail(Model model,@PathVariable Integer id, @PathVariable String slug) {
        model.addAttribute("blog", blogService.getBlogInfoById(id));
        model.addAttribute("rencentsPost", blogService.getRecentBLog());
        model.addAttribute("categories", categoryRepository.findAll());
        return "web/detail";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "web/contact";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "web/about";
    }

}
