package com.example.coron.service;

import com.example.coron.dto.CartInfo;
import com.example.coron.dto.OrderHeaders;
import com.example.coron.dto.OrderInfo;
import com.example.coron.entity.Order;
import com.example.coron.entity.Shop;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.mapper.OrderCreateRequestMapper;
import com.example.coron.mapper.OrderCreateResponseMapper;
import com.example.coron.repository.OrderRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private RequestService requestService;
    @Autowired
    private ModelMapper modelMapper;

    public SimpleFeedback create(OrderCreateRequestMapper requestMapper, OrderCreateResponseMapper responseMapper, OrderHeaders headers) {
        SimpleFeedback feedback = new SimpleFeedback();

        LocalDateTime dateTime = LocalDateTime.parse(responseMapper.getData().getExpected_delivery_time(), DateTimeFormatter.ISO_DATE_TIME);
        Order order = Order.builder()
                .orderCode(responseMapper.getData().getOrder_code())
                .paymentTypeId(requestMapper.getPayment_type_id())
                .requiredNote(requestMapper.getRequired_note())
                .serviceTypeId(requestMapper.getService_type_id())
                .shop(headers.getShop())
                .expectedDeliveryTime(dateTime)
                .shipFee(responseMapper.getData().getTotal_fee())
                .receiver(headers.getUser())
                .status(0)
                .build();
        orderRepository.save(order);
        cartService.updateOrder(headers.getCarts(),order);
        return feedback;
    }


    public SimpleFeedback createNewOrder(String requestBody, Map<String, String> headers) throws IOException, InterruptedException, URISyntaxException {
        SimpleFeedback feedback = new SimpleFeedback();
        Object[] headersObject = requestService.validateOrderHeaders(headers);
        OrderHeaders orderHeaders;
        SimpleFeedback validateHeadersFeedback = (SimpleFeedback) headersObject[0];
        if (!validateHeadersFeedback.isValidate()){
            return validateHeadersFeedback;
        } else {
            OrderHeaders hd = (OrderHeaders) headersObject[1];
            orderHeaders= OrderHeaders.builder()
                    .user(hd.getUser())
                    .shop(hd.getShop())
                    .carts(hd.getCarts()).build() ;
        }
        System.out.println(headers.get("carts"));
        System.out.println(orderHeaders.getCarts());
        SimpleFeedback checkChangeListCart  = cartService.changeListCartStatus(orderHeaders.getCarts(),1,2);

        if (!checkChangeListCart.isValidate()){
            return checkChangeListCart;
        };


        requestBody= requestBody.replaceAll("\\r\\n|\\r|\\n", "");
        requestBody= requestBody.replaceAll("\\s", "");

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://dev-online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/create"))
                .header("Content-type", "application/json")
                .headers("shop_id", headers.get("shop_id"),"token", orderHeaders.getShop().getToken())
                .POST(BodyPublishers.ofString(requestBody))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse= httpClient.send(postRequest, BodyHandlers.ofString());


        Gson gson= new Gson();
        OrderCreateRequestMapper orderRequest = gson.fromJson(requestBody,OrderCreateRequestMapper.class);
        OrderCreateResponseMapper orderResponse = gson.fromJson(postResponse.body(),OrderCreateResponseMapper.class);
        if (orderResponse.getCode()==200){
            return create(orderRequest,orderResponse, orderHeaders);
        } else {
            cartService.changeListCartStatus(orderHeaders.getCarts(),2,1);
            feedback.setValidate(false);
            feedback.setMessage(postResponse.body());
        }
        return feedback;
    }

    public List<OrderInfo> getAllOrder(){
        List<OrderInfo> list = orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order,OrderInfo.class))
                .collect(Collectors.toList());
        list.forEach(orderInfo -> orderInfo.setCarts(cartService.getListCartByOrderId(orderInfo.getId())));
        return list;
    }

    public SimpleFeedback changeStatusOrderById(Integer id, Integer status) {
        Object[] orderObject = getById(id);
        SimpleFeedback feedback = (SimpleFeedback) orderObject[0];
        if (feedback.isValidate()){
            Order order = (Order) orderObject[1];
            order.setStatus(status);
        }
        return feedback;
    }

    private Object[] getById(Integer id) {
        SimpleFeedback simpleFeedback = new SimpleFeedback();
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()){
            SimpleFeedback feedback = new SimpleFeedback(false, "Not found order have id= "+id);
            return new Object[]{feedback};
        }
        return new Object[]{simpleFeedback,order.get()};
    }

}
