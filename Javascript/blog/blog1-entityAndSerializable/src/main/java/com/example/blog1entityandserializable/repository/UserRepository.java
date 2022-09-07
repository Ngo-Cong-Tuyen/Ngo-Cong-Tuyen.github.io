package com.example.blog1entityandserializable;

import com.example.blog1entityandserializable.entity.User;
import com.example.blog1entityandserializable.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}