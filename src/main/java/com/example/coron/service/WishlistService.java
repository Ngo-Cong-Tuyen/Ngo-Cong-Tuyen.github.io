package com.example.coron.service;

import com.example.coron.dto.WishlistInfo;
import com.example.coron.entity.Product;
import com.example.coron.entity.User;
import com.example.coron.entity.Wishlist;
import com.example.coron.repository.ProductRepository;
import com.example.coron.repository.UserRepository;
import com.example.coron.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WishlistRepository wishlistRepository;

    public String addToWishlist(String email, String sku) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return "Not authorized user";
        }
        Optional<Product> product = productRepository.findBySku(sku);
        if (product.isEmpty()) {
            return "Not found product";
        }
        Optional<Wishlist> wishlistCheck = wishlistRepository.findByUser_EmailAndProduct_Sku(email,sku);
        if (wishlistCheck.isPresent()) {
            wishlistCheck.get().setStatus(1);
            wishlistRepository.save(wishlistCheck.get());
            return "Successfully process";
        }
        Wishlist wishlist = Wishlist.builder()
                .user(user.get())
                .product(product.get())
                .status(1).build();
        wishlistRepository.save(wishlist);
        return "Successfully process";
    }

    public List<WishlistInfo> getWishlist(String email) {
        return wishlistRepository.getWishListInfoByEmail(email);
    }

    public String removeProduct(String email, String sku) {
        Optional<Wishlist> wishlistCheck = wishlistRepository.findByUser_EmailAndProduct_Sku(email,sku);
        if (wishlistCheck.isEmpty()) {
            return "Not found product in Wishlist";
        }
        wishlistCheck.get().setStatus(0);
        wishlistRepository.save(wishlistCheck.get());
        return "Successfully process";
    }
}
