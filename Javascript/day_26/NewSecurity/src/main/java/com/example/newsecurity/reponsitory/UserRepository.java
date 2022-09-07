package com.example.newsecurity.reponsitory;

import com.example.newsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}