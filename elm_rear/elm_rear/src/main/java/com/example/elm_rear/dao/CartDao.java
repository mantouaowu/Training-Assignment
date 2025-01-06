package com.example.elm_rear.dao;

import com.example.elm_rear.po.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDao extends JpaRepository<Cart, Long> {
    // 查询用户的所有购物车项
    List<Cart> findByUserId(String userId);

    // 查询用户在特定商家的购物车项
    List<Cart> findByUserIdAndBusinessId(String userId, Long businessId);

    // 查询特定的购物车项
    Cart findByUserIdAndBusinessIdAndFoodId(String userId, Long businessId, Long foodId);

    // 删除用户在特定商家的所有购物车项
    void deleteByUserIdAndBusinessId(String userId, Long businessId);
}