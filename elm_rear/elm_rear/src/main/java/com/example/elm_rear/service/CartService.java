package com.example.elm_rear.service;

import com.example.elm_rear.po.Cart;
import com.example.elm_rear.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartDao cartDao;

    // 查询用户购物车
    public List<Cart> listCart(String userId, Long businessId) {
        if (businessId != null) {
            return cartDao.findByUserIdAndBusinessId(userId, businessId);
        }
        return cartDao.findByUserId(userId);
    }

    // 添加购物车
    @Transactional
    public Cart saveCart(Cart cart) {
        // 检查是否已存在相同商品
        Cart existingCart = cartDao.findByUserIdAndBusinessIdAndFoodId(
                cart.getUserId(), cart.getBusinessId(), cart.getFoodId());

        if (existingCart != null) {
            // 如果存在，增加数量
            existingCart.setQuantity(existingCart.getQuantity() + 1);
            return cartDao.save(existingCart);
        }

        // 不存在则新建，默认数量为1
        cart.setQuantity(1);
        return cartDao.save(cart);
    }

    // 更新购物车数量
    public Cart updateCart(Cart cart) {
        Cart existingCart = cartDao.findByUserIdAndBusinessIdAndFoodId(
                cart.getUserId(), cart.getBusinessId(), cart.getFoodId());

        if (existingCart != null) {
            existingCart.setQuantity(cart.getQuantity());
            return cartDao.save(existingCart);
        }
        return null;
    }

    // 移除购物车项
    @Transactional
    public void removeCart(String userId, Long businessId, Long foodId) {
        Cart cart = cartDao.findByUserIdAndBusinessIdAndFoodId(userId, businessId, foodId);
        if (cart != null) {
            cartDao.delete(cart);
        }
    }

    // 清空用户在特定商家的购物车
    @Transactional
    public void removeCartByBusinessId(String userId, Long businessId) {
        cartDao.deleteByUserIdAndBusinessId(userId, businessId);
    }
}