package com.example.coron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String getBlogsPage(Model model) {
        return "web/index";
    }

    @GetMapping("/single-product")
    public String getDetailPage(Model model) {
        return "web/single-product";
    }
}
