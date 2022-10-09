package com.example.coron.controller;

import com.example.coron.security.UserDetailsCustom;
import com.example.coron.service.AuthService;
import com.example.coron.service.CartService;
import com.example.coron.service.ProductService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller

public class WebController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private AuthService authService;


    @GetMapping("/layout")
    public String getLayoutPage(Model model) {
        return "layout/layout";
    }

    // Get index page 1
    @GetMapping("/")
    public String getHomePage(Model model) {
        String email = authService.checkUser();
        model.addAttribute("carts", cartService.getAllCartInfoByUserEmail(email));
        model.addAttribute("products", productService.getAllProductDto());
        return "web/index";
    }

    // Get index page 2
    @GetMapping("/index")
    public String getBlogsPage(Model model) {
        return "web/index-2";
    }


    // Get shop page

    @GetMapping("/shop-list")
    public String getShopListPage(Model model) {
        return "web/shop-list";
    }

    @GetMapping("/shop-fullwidth")
    public String getShopFullWidthPage(Model model) {
        return "web/shop-fullwidth";
    }

    @GetMapping("/shop-fullwidth-list")
    public String getShopFullWidthListPage(Model model) {
        return "web/shop-fullwidth-list";
    }

    @GetMapping("/shop-sidebar")
    public String getShopSidebarPage(Model model) {
        return "web/shop-sidebar";
    }


    @GetMapping("/shop-sidebar-list")
    public String getShopSidebarListPage(Model model) {
        return "web/shop-sidebar-list";
    }



    @GetMapping("/single-product-sidebar")
    public String getSingleProductSidebarPage(Model model) {
        return "web/single-product-sidebar";
    }

    @GetMapping("/single-product-video")
    public String getSingleProductVideoPage(Model model) {
        return "web/single-product-video";
    }

    @GetMapping("/single-product-gallery")
    public String getSingleProductGalleryPage(Model model) {
        return "web/single-product-gallery";
    }
    @GetMapping("/contact")
    public String getContactPage(Model model) {
        return "web/contact";
    }

    @GetMapping("/wishlist")
    public String getWishlistPage(Model model) {
        return "web/wishlist";
    }



    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "web/login";
    }

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/500";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "error/403";
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                return "error/401";
            }  else {
                return "error/error";
            }
        }

        return "error/error";
    }
}
