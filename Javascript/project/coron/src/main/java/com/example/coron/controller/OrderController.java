package com.example.coron.controller;

import com.example.coron.request.OrderCreateRequest;
import com.example.coron.request.ShopCreateRequest;
import com.example.coron.service.CartService;
import com.example.coron.service.OrderService;
import com.example.coron.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ShopService shopService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/admin/orders")
    public String getListOrderPage(Model model){
        model.addAttribute("listCartUsers", cartService.getListCartInfo());
        return "/admin/order/list-order";
    }

    @GetMapping("/admin/users")
    public String getListUserPage(){
        return "/admin/user/list-user";
    }

    @PostMapping("api/v1/admin/shops/create")
    @ResponseBody
    public String addShop(@RequestBody ShopCreateRequest request){
        return shopService.create(request);
    }

    @PostMapping("api/v1/admin/orders/create")
    @ResponseBody
    public String createOrder(@RequestBody OrderCreateRequest request){
        return orderService.create(request);
    }
}
