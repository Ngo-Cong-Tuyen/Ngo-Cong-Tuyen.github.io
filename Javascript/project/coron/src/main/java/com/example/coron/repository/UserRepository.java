package com.example.coron.repository;

import com.example.coron.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    @Transactional
    @Modifying
    @Query("update User u set u.enabled=true where u.email= ?1")
    void activeUser(String email);
}