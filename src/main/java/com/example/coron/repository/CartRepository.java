package com.example.coron.repository;

import com.example.coron.dto.CartInfo;
import com.example.coron.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(nativeQuery = true, name = "getAllCartInfoByUserId")
    List<CartInfo> getCartInfoByUserId(Integer userId);

    @Query(nativeQuery = true, name = "getAllCartOrder")
    List<CartInfo> getListCartByOrderId(Integer orderId);

    @Query(nativeQuery = true, name = "getAllNewCartInfo")
    List<CartInfo> getListNewCartInfo();

    List<Cart> findByUser_IdAndStatus(Integer id, Integer status);

    List<Cart> findByIdInAndStatus(Collection<Integer> ids, Integer status);

    @Query("select c from Cart c where c.user.email = ?1 and c.amount.product.sku = ?2 and c.status = ?3")
    List<Cart> findByUser_EmailAndAmount_Product_SkuAndStatus(String email, String sku, Integer status);




}