package com.example.elm_rear.controller;

import com.example.elm_rear.po.Food;
import com.example.elm_rear.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/business/{businessId}")
    public List<Food> listFoodByBusinessId(@PathVariable Long businessId) {
        return foodService.listFoodByBusinessId(businessId);
    }
}