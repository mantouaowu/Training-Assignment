package com.example.elm_rear.dao;

import com.example.elm_rear.po.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDao extends JpaRepository<Food, Long> {
    List<Food> findByBusinessId(Long businessId);
}