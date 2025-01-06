package com.example.elm_rear.po;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessId;

    @Column(nullable = false)
    private String businessName;

    @Column
    private String businessImg;

    @Column
    private String businessExplain;

    @Column(precision = 5, scale = 2)
    private BigDecimal starPrice;  // 起送费

    @Column(precision = 5, scale = 2)
    private BigDecimal deliveryPrice;  // 配送费

    @Column
    private Integer orderTypeId;  // 商家分类ID

    // Getters and Setters
    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public BigDecimal getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(BigDecimal starPrice) {
        this.starPrice = starPrice;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
}