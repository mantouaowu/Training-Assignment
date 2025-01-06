package com.example.elm_rear.service;

import com.example.elm_rear.dao.OrderDao;
import com.example.elm_rear.dao.OrderDetailDao;
import com.example.elm_rear.po.Order;
import com.example.elm_rear.po.OrderDetail;
import com.example.elm_rear.po.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private CartService cartService;

    // 获取用户订单
    public List<Order> listOrdersByUserId(String userId) {
        return orderDao.findByUserId(userId);
    }

    // 获取订单详情
    public Order getOrderById(Long orderId) {
        return orderDao.findById(orderId).orElse(null);
    }

    // 创建订单
    @Transactional
    public Order createOrder(Order order, List<Cart> cartItems) {
        // 设置订单基本信息
        order.setOrderDate(new Date());
        order.setOrderState(0);  // 未支付状态

        // 保存订单
        Order savedOrder = orderDao.save(order);

        // 创建订单明细
        for (Cart cart : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrderId(savedOrder.getOrderId());
            detail.setFoodId(cart.getFoodId());
            detail.setQuantity(cart.getQuantity());
            orderDetailDao.save(detail);
        }

        // 清空购物车
        cartService.removeCartByBusinessId(order.getUserId(), order.getBusinessId());

        return savedOrder;
    }

    // 更新订单状态
    @Transactional
    public Order updateOrderState(Long orderId, Integer orderState) {
        Order order = orderDao.findById(orderId).orElse(null);
        if (order != null) {
            order.setOrderState(orderState);
            return orderDao.save(order);
        }
        return null;
    }
}