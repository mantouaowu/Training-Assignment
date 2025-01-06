package com.example.elm_rear.repository;

import com.example.elm_rear.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {  // tring类型的ID
    User findByUserId(String userId);  // serId查询
}
