package com.example.coron.repository;

import com.example.coron.entity.Amount;
import com.example.coron.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface AmountRepository extends JpaRepository<Amount, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Amount a where a.product = ?1")
    void deleteByProduct(Product product);



}