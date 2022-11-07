package com.example.coron.controller;

import com.example.coron.dto.ProductDto;
import com.example.coron.dto.ProductInfo;
import com.example.coron.entity.Product;
import com.example.coron.service.AuthService;
import com.example.coron.service.CartService;
import com.example.coron.service.ProductService;
import com.example.coron.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class WebController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private AuthService authService;
    @Autowired
    private WishlistService wishlistService;



    @GetMapping("/")
    public String getHomePage(Model model) {
        String email = authService.checkUser();
        model.addAttribute("carts", cartService.getAllCartInfoByUserEmail(email));
        Page<Product> page = productService.getAllProduct(1,6, "createdAt");
        List<ProductDto> products = productService.mapperProductToProductDto(page.getContent());
        model.addAttribute("products", products);
        List<ProductInfo> hotProducts =  productService.getHotProducts();
        model.addAttribute("hotProducts", hotProducts);
        model.addAttribute("wishlist", wishlistService.getWishlist(email));
        return "web/index";
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
