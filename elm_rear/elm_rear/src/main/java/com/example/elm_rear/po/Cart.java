package com.example.elm_rear.po;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Long businessId;

    @Column(nullable = false)
    private Long foodId;

    @Column(nullable = false)
    private Integer quantity;

    // 添加业务关联
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "businessId", insertable = false, updatable = false)
    private Business business;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foodId", insertable = false, updatable = false)
    private Food food;

    // Getters and Setters
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}