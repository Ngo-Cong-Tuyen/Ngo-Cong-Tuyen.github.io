package com.example.user.repository;

import com.example.user.dto.UserDto;
import com.example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
//JPQL JPA query language
//    @Query("select new com.example.user.dto.UserDto(u.id, u.name, u.email,u.phone,u.address, u.avatar) from User u")
//    List<UserDto> getAllUserDto();

    //Su dung native query
//    @Query(nativeQuery = true, value = "select id,name,email,phone,address,avatar from user")
//    List<UserDto> getAllUserDto();

    @Query(nativeQuery = true, name = "getAllUserDto")
    List<UserDto> getAllUserDto();



}