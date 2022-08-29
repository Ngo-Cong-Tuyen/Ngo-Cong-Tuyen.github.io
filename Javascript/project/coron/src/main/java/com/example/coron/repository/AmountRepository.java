package com.example.coron.repository;

import com.example.coron.entity.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountRepository extends JpaRepository<Amount, Integer> {
}