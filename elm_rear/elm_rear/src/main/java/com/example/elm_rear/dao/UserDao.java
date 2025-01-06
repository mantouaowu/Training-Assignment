package com.example.elm_rear.dao;

import com.example.elm_rear.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
    User findByUserId(String userId);
}