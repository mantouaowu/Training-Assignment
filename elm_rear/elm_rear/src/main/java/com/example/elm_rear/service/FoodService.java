package com.example.elm_rear.service;

import com.example.elm_rear.po.Food;
import com.example.elm_rear.dao.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodDao foodDao;

    public List<Food> listFoodByBusinessId(Long businessId) {
        return foodDao.findByBusinessId(businessId);
    }
}