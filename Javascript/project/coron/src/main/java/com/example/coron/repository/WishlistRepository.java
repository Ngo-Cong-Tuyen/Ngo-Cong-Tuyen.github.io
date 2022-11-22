package com.example.coron.repository;

import com.example.coron.dto.WishlistInfo;
import com.example.coron.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    @Query(nativeQuery = true, name = "getWishlistInfo")
    List<WishlistInfo>  getWishListInfoByEmail(String email);

    Optional<Wishlist> findByUser_EmailAndProduct_Sku(String email, String sku);

}