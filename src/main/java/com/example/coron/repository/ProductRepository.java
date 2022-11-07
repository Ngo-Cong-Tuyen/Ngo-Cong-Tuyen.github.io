package com.example.coron.repository;

import com.example.coron.dto.ProductInfo;
import com.example.coron.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findBySku(String sku);

    @Query("select distinct p from Product p inner join p.categories categories inner join p.amounts amounts" +
            " where concat(p.name, ' ', p.sku ) like %?1%" +
            "and categories.name like ?2%" +
            "and amounts.color like %?3%")
    Page<Product> getAllProductInfo(String keyword,String category,String color, Pageable pageable);

    @Query(nativeQuery = true, name = "getHotProductInfos")
    List<ProductInfo> getHotProductInfos();

}