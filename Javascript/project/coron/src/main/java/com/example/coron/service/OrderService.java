package com.example.coron.service;

import com.example.coron.dto.OrderInfo;
import com.example.coron.entity.Cart;
import com.example.coron.entity.Order;
import com.example.coron.entity.Shop;
import com.example.coron.repository.CartRepository;
import com.example.coron.repository.OrderRepository;
import com.example.coron.repository.ShopRepository;
import com.example.coron.request.OrderCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;

    public String create(OrderCreateRequest request) {
        Optional<Shop> shop = shopRepository.findByShopId(request.getUserId());
        if (shop.isEmpty()){
            return "Shop id: " + request.getShopId()+ " is not valid!";
        }
        Order order = Order.builder()
                .order_code(request.getOrder_code())
                .paymentTypeId(request.getPaymentTypeId())
                .requiredNote(request.getRequiredNote())
                .serviceTypeId(request.getServiceTypeId())
                .shop(shop.get())
                .expectedDeliveryTime(request.getExpectedDeliveryTime())
                .shipFee(request.getShipFee())
                .build();
        orderRepository.save(order);
        List<Cart> carts = cartRepository.findAllById(request.getCarts());
        carts.forEach(cart -> {
            cart.setStatus(2);
            cart.setOrder(order);
        });
        cartRepository.saveAll(carts);
        return "Create successfull";
    }
}
