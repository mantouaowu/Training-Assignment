package com.example.elm_rear.service;

import com.example.elm_rear.po.Business;
import com.example.elm_rear.dao.BusinessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {
    @Autowired
    private BusinessDao businessDao;

    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessDao.findByOrderTypeId(orderTypeId);
    }

    public Business getBusinessById(Long businessId) {
        return businessDao.findById(businessId).orElse(null);
    }
    public Business addBusiness(Business business) {
        if (business.getBusinessName() == null || business.getBusinessName().trim().isEmpty()) {
            throw new IllegalArgumentException("商家名称不能为空");
        }
        if (business.getOrderTypeId() == null) {
            throw new IllegalArgumentException("商家分类不能为空");
        }
        if (business.getStarPrice() == null) {
            throw new IllegalArgumentException("起送费不能为空");
        }
        if (business.getDeliveryPrice() == null) {
            throw new IllegalArgumentException("配送费不能为空");
        }

        return businessDao.save(business);
    }
}