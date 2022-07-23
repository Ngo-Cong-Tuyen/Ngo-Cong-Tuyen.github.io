package com.example.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/hotel")
    public String getHotelPage(){
        return "hotel";
    }

    @GetMapping("/rentar")
    public String getRentarPage(){
        return "rentar";
    }

    @GetMapping("/tour")
    public String getTourPage(){
        return "tour";
    }
}
