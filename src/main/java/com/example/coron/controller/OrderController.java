package com.example.coron.controller;

import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.request.OrderCreateRequest;
import com.example.coron.request.ShopCreateRequest;
import com.example.coron.service.CartService;
import com.example.coron.service.OrderService;
import com.example.coron.service.ShopService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.stream.Collectors;

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
        model.addAttribute("orders", orderService.getAllOrder());
        return "admin/order/list-order";
    }


    @PostMapping("/api/v1/admin/shops/create")
    @ResponseBody
    public String addShop(@RequestBody ShopCreateRequest request){
        return shopService.create(request);
    }

    @PostMapping("/api/v2/admin/orders/create")
    @ResponseBody
    public SimpleFeedback createNewOrder(@RequestBody String requestBody, @RequestHeader Map<String, String> headers) throws IOException, URISyntaxException, InterruptedException {
        return orderService.createNewOrder(requestBody, headers);

    }

    @PutMapping("/api/v1/admin/orders/{id}/cancel")
    @ResponseBody
    public SimpleFeedback cancelOrderById(@PathVariable Integer id){
        return orderService.changeStatusOrderById(id, -1);
    }

    @PutMapping("/api/v1/admin/orders/{id}/update")
    @ResponseBody
    public SimpleFeedback updateOrderById(@PathVariable Integer id){
        return orderService.changeStatusOrderById(id, 1);
    }

    @PutMapping("/api/v1/admin/orders/{id}/raise")
    @ResponseBody
    public SimpleFeedback raiseOrderById(@PathVariable Integer id){
        return orderService.changeStatusOrderById(id, 0);
    }

    @PutMapping("/api/v1/admin/orders/{id}/complete")
    @ResponseBody
    public SimpleFeedback completeOrderById(@PathVariable Integer id){
        return orderService.changeStatusOrderById(id, 0);
    }
}
