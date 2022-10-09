package com.example.coron.controller;

import com.example.coron.dto.CartInfo;
import com.example.coron.entity.User;
import com.example.coron.request.CartRequest;
import com.example.coron.request.ListCartRequest;
import com.example.coron.security.UserDetailsCustom;
import com.example.coron.service.AuthService;
import com.example.coron.service.CartService;
import com.example.coron.service.ShopService;
import com.example.coron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AuthService authService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserService userService;

    @GetMapping("/cart")
    public String getCartPage(Model model) {
        String email = authService.checkUser();
        model.addAttribute("checkAddress", userService.checkAddress(email));
        model.addAttribute("carts", cartService.getAllCartInfoByUserEmail(email));
        return "web/cart";
    }

    // Add a product to the cart
    @PostMapping("/api/cart/{email}/upload")
    @ResponseBody
    public void addToCart(@PathVariable String email, @RequestBody CartRequest request){
        cartService.add(request,email);
    }

    // Delete a product in the cart
    @DeleteMapping("/api/cart/{id}/delete")
    @ResponseBody
    public void DeleteProductInCart(@PathVariable Integer id){
        cartService.delete(id);
    }

    // Process checkout
    @PostMapping("/api/cart/{email}/checkout")
    @ResponseBody
    public void checkoutCart(@PathVariable String email){
        cartService.checkoutByUserEmail(email);
    }

    // Check out page
    @GetMapping("/checkout")
    public String getCheckoutPage(){
        return "web/checkout";
    }

    // Admin manager cart
    @GetMapping("/admin/carts")
    public String getManagerCartPage(Model model){
        model.addAttribute("listCartUsers", cartService.getListCartInfo());
        model.addAttribute("shops", shopService.getAllShop());
        return "/admin/order/list-cart";
    }

    @PutMapping("/api/v1/admin/carts/delete")
    @ResponseBody
    public void cancelListCart(@RequestBody ListCartRequest carts){
        cartService.cancelListCart(carts.getCarts());
    }
}
