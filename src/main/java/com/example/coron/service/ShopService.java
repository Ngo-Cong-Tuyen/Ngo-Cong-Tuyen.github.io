package com.example.coron.service;

import com.example.coron.entity.Shop;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.repository.ShopRepository;
import com.example.coron.request.ShopCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public String create(ShopCreateRequest request) {
        if (shopRepository.findByShopId(request.getShopId()).isPresent()){
            return "Shop id: "+ request.getShopId()+" is present";
        }
        Shop shop = Shop.builder()
                .shopId(request.getShopId())
                .name(request.getName())
                .address(request.getAddress())
                .token(request.getToken()).build();
        shopRepository.save(shop);
        return "Add shop successfully";
    }

    public List<Shop> getAllShop() {
        return shopRepository.findAll();
    }

    public Object[] getShopByShopId(Integer shopId){
        Optional<Shop> shop = shopRepository.findByShopId(shopId);
        if (shop.isEmpty()){
            SimpleFeedback feedback = new SimpleFeedback(false, "Not found shop id : "+ shopId);
            return new Object[]{feedback};
        }
        return new Object[]{new SimpleFeedback(),shop.get()};
    }
}
