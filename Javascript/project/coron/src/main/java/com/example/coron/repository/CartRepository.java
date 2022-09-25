package com.example.coron.repository;

import com.example.coron.dto.CartInfo;
import com.example.coron.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(nativeQuery = true, name = "getAllCartInfoByUserId")
    List<CartInfo> getCartInfoByUserId(Integer userId);


    @Query(nativeQuery = true, name = "getAllNewCartInfo")
    List<CartInfo> getListNewCartInfo();

    List<Cart> findByUser_IdAndStatus(Integer id, Integer status);


}