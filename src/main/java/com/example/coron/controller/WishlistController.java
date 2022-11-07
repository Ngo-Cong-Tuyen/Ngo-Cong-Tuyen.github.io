package com.example.coron.controller;

import com.example.coron.service.AuthService;
import com.example.coron.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private AuthService authService;

    @GetMapping("/wishlist")
    public String getWishlistPage(Model model) {
        String email = authService.checkUser();
        model.addAttribute("wishlist", wishlistService.getWishlist(email));
        return "web/wishlist";
    }

    @PostMapping("/api/v2/wishlist/{email}/{sku}")
    @ResponseBody
    public String addToWishlist(@PathVariable String email, @PathVariable String sku){
        return   wishlistService.addToWishlist(email,sku);
    }

    @DeleteMapping("/api/v2/wishlist/{email}/{sku}")
    @ResponseBody
    public String deleteProductOutWishlist(@PathVariable String email, @PathVariable String sku){
        return   wishlistService.removeProduct(email,sku);
    }
}
