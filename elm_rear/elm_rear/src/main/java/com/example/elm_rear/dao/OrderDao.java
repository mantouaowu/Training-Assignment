package com.example.elm_rear.dao;

import com.example.elm_rear.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {
    List<Order> findByUserId(String userId);
}