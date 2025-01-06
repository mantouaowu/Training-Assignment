package com.example.elm_rear.po;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")  // 使用orders作为表名，因为order是SQL关键字
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Long businessId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal orderTotal;

    @Column(nullable = false)
    private Long daId;  // 配送地址ID

    @Column(nullable = false)
    private Integer orderState;  // 订单状态：0未支付，1已支付

    @Column(nullable = false)
    private Date orderDate;

    // 关联查询
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "businessId", insertable = false, updatable = false)
    private Business business;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> list;

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Long getDaId() {
        return daId;
    }

    public void setDaId(Long daId) {
        this.daId = daId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<OrderDetail> getList() {
        return list;
    }

    public void setList(List<OrderDetail> list) {
        this.list = list;
    }
}