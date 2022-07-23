package com.example.shop.controller;

import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("productDiscount",productService.getProductsDisCount(4));
        model.addAttribute("productSell",productService.getProductsSell(4));
        return "index";
    }

    @GetMapping("/shop")
    public String getShopPage(){
        return "shop";
    }

    @GetMapping("/buy")
    public String getBuyPage(){
        return "buy";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }
}
