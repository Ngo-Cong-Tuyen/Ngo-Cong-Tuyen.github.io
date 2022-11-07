package com.example.coron.service;

import com.example.coron.dto.CartInfo;
import com.example.coron.dto.ListCartInfo;
import com.example.coron.entity.User;
import com.example.coron.entity.Amount;
import com.example.coron.entity.Cart;
import com.example.coron.entity.Order;
import com.example.coron.exception.NotFoundException;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.repository.AmountRepository;
import com.example.coron.repository.CartRepository;
import com.example.coron.repository.UserRepository;
import com.example.coron.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private AmountRepository amountRepository;

    @Autowired
    private UserService userService;


    public void add(CartRequest request, String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()->{
            throw new NotFoundException("Not found user have email: " + email);
        });

        Amount amount = amountRepository.findById(request.getAmountId()).orElseThrow(()->{
            throw new NotFoundException("Not found amount have id: " + request.getAmountId());
        });

        Cart cart = Cart.builder()
                .status(0)
                .amount(amount)
                .user(user)
                .quantity(request.getQuantity()).build();

        cartRepository.save(cart);
    }

    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }

    public List<CartInfo> getAllCartInfoByUserEmail(String email){
        if (email.equals("anonymousUser")) return null;
        User user = userRepository.findByEmail(email).orElseThrow(()->{
            throw new NotFoundException("Not found email have: "+ email);
        });
        return cartRepository.getCartInfoByUserId(user.getId());
    }

    public void checkoutByUserEmail(String email) {
        Integer userid = userRepository.findByEmail(email).get().getId();
        List<Cart> carts= cartRepository.findByUser_IdAndStatus(userid,0);
        carts.forEach(cart -> {
            cart.setStatus(1);
            Amount amount= cart.getAmount();
            int quantity = amount.getQuantity()- cart.getQuantity();
            amount.setQuantity(quantity);
            amountRepository.save(amount);
        });
        cartRepository.saveAll(carts);
    }

    public List<ListCartInfo> getListCartInfo(){
       List<CartInfo> cartInfoList=  cartRepository.getListNewCartInfo();
       ArrayList<Integer> userIds = new ArrayList<>();
       cartInfoList.forEach(cartInfo -> {
           if (!userIds.contains(cartInfo.getUserId())) userIds.add(cartInfo.getUserId());
       });
       List<ListCartInfo> lists =new ArrayList<>();
       List<User> users = userRepository.findAllById(userIds);
       for (User user : users){
           List<CartInfo> list= cartInfoList.stream().filter(cartInfo -> cartInfo.getUserId()== user.getId()).collect(Collectors.toList());
           ListCartInfo listCartInfo= new ListCartInfo(user.getId(), user.getName(), user.getPhone(), user.getAddress(),list);
           lists.add(listCartInfo);
       };
       return lists;
    }

    // Cancel List Cart
    public void cancelListCart(List<Integer> carts) {
        List<Cart> listCart = cartRepository.findAllById(carts);
        for (Cart cart : listCart ) {
            cart.setStatus(-1);
        }
        cartRepository.saveAll(listCart);
    }


    public SimpleFeedback changeListCartStatus(List<Integer> carts, Integer statusIn, Integer statusOut ){
        SimpleFeedback feedback = new SimpleFeedback();
        List<Cart> listCarts = cartRepository.findByIdInAndStatus(carts, statusIn);
        if (listCarts.isEmpty()){
            feedback.setValidate(false);
            feedback.setMessage("Not found any cart have status= "+ statusIn);
            return feedback;
        }
        listCarts.forEach(cart -> cart.setStatus(statusOut));
        cartRepository.saveAll(listCarts);
        return feedback;
    }

    public void updateOrder(List<Integer> listCarts, Order order){
        List<Cart> carts = cartRepository.findAllById(listCarts);
        carts.forEach(cart -> {
            cart.setOrder(order);
        });
        cartRepository.saveAll(carts);
    }

    public List<CartInfo> getListCartByOrderId(Integer orderId){
        return cartRepository.getListCartByOrderId(orderId);
    }
}
