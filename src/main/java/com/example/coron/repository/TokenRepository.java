package com.example.coron.repository;

import com.example.coron.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findByToken(String token);
    @Transactional
    @Modifying
    @Query("update Token t set t.confirmedAt= ?2 where t.token= ?1")
    void activeToken(String tokenString, LocalDateTime time);
}