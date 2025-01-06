package com.example.elm_rear.controller;

import com.example.elm_rear.po.Cart;
import com.example.elm_rear.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    // 查询购物车
    @GetMapping
    public ResponseEntity<List<Cart>> listCart(
            @RequestParam String userId,
            @RequestParam(required = false) Long businessId) {
        return ResponseEntity.ok(cartService.listCart(userId, businessId));
    }

    // 添加购物车
    @PostMapping
    public ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.saveCart(cart));
    }
    // 更新购物车数量
    @PutMapping
    public ResponseEntity<?> updateCart(@RequestBody Cart cart) {
        Cart updated = cartService.updateCart(cart);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // 移除购物车项
    @DeleteMapping("/{userId}/{businessId}/{foodId}")
    public ResponseEntity<?> removeCart(
            @PathVariable String userId,
            @PathVariable Long businessId,
            @PathVariable Long foodId) {
        cartService.removeCart(userId, businessId, foodId);
        return ResponseEntity.ok().build();
    }

    // 清空商家购物车
    @DeleteMapping("/{userId}/{businessId}")
    public ResponseEntity<?> removeCartByBusinessId(
            @PathVariable String userId,
            @PathVariable Long businessId) {
        cartService.removeCartByBusinessId(userId, businessId);
        return ResponseEntity.ok().build();
    }
}