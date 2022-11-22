package com.example.coron.service;

import com.example.coron.dto.OrderHeaders;
import com.example.coron.entity.User;
import com.example.coron.entity.Shop;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.util.UtilsBackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RequestService {
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserService userService;
    @Autowired
    private UtilsBackend utilsBackend;

    public Object[] validateOrderHeaders(Map<String, String> headers){
        SimpleFeedback feedback = new SimpleFeedback();
        OrderHeaders orderHeaders = new OrderHeaders();
        Integer shopId = Integer.valueOf(headers.get("shop_id"));
        Integer userId = Integer.valueOf(headers.get("user_id"));
        String listCarts = headers.get("carts");
        String message= "";
        if (shopId==null){
            feedback.setValidate(false);
            message+=" Missing param list carts! ";
        }
        if (userId==null){
            feedback.setValidate(false);
            message+=" Missing param user_id ";
        }
        if (listCarts==null){
            feedback.setValidate(false);
            message+=" Missing param carts ";
        }
        if (!feedback.isValidate()){
            feedback.setMessage(message);
            return new Object[]{feedback};
        }
        Object[] shopObject= shopService.getShopByShopId(shopId);
        SimpleFeedback shopFeedback=(SimpleFeedback) shopObject[0];
        if (!shopFeedback.isValidate()){
            return new Object[]{shopFeedback};
        } else {
            orderHeaders.setShop((Shop) shopObject[1]);
        }
        Object[] userObject = userService.findUserById(userId);
        SimpleFeedback userFeedback= (SimpleFeedback) userObject[0];
        if(!userFeedback.isValidate()){
            return new Object[]{userFeedback};
        } else {
            orderHeaders.setUser((User) userObject[1]);
        }
        List<Integer> carts = utilsBackend.changeStringToList(headers.get("carts"));
        orderHeaders.setCarts(carts);
        return new Object[]{feedback,orderHeaders};
    }
}
