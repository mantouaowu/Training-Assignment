package com.example.elm_rear.controller;

import com.example.elm_rear.po.Business;
import com.example.elm_rear.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/listByOrderType/{orderTypeId}")
    public List<Business> listBusinessByOrderTypeId(@PathVariable Integer orderTypeId) {
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }

    @GetMapping("/{businessId}")
    public Business getBusinessById(@PathVariable Long businessId) {
        return businessService.getBusinessById(businessId);
    }
    @PostMapping
    public Business addBusiness(@RequestBody Business business) {
        return businessService.addBusiness(business);
    }
}