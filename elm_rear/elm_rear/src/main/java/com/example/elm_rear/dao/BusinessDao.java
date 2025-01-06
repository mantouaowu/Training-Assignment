package com.example.elm_rear.dao;

import com.example.elm_rear.po.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessDao extends JpaRepository<Business, Long> {
    List<Business> findByOrderTypeId(Integer orderTypeId);
}