package com.example.elm_rear.controller;

import com.example.elm_rear.po.Order;
import com.example.elm_rear.po.Cart;
import com.example.elm_rear.service.OrderService;
import com.example.elm_rear.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    // 获取用户订单列表
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> listOrdersByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.listOrdersByUserId(userId));
    }

    // 获取订单详情
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    // 创建订单
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        try {
            // 获取用户购物车中的商品
            List<Cart> cartItems = cartService.listCart(order.getUserId(), order.getBusinessId());
            if (cartItems.isEmpty()) {
                return ResponseEntity.badRequest().body("购物车为空");
            }

            Order createdOrder = orderService.createOrder(order, cartItems);
            return ResponseEntity.ok(createdOrder);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("创建订单失败: " + e.getMessage());
        }
    }

    // 更新订单状态（支付）
    @PutMapping("/{orderId}/state")
    public ResponseEntity<?> updateOrderState(
            @PathVariable Long orderId,
            @RequestParam Integer orderState) {
        Order updatedOrder = orderService.updateOrderState(orderId, orderState);
        if (updatedOrder == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedOrder);
    }
}