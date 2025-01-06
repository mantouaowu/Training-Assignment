package com.example.elm_rear.controller;

import com.example.elm_rear.po.User;
import com.example.elm_rear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        try {
            // 检查用户是否已存在
            User existingUser = userService.getUserById(user.getUserId());
            if (existingUser != null) {
                return ResponseEntity.badRequest().body("用户已存在");
            }

            // 设置默认值
            user.setCreateTime(new Date());

            // 创建新用户
            User savedUser = userService.createUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("创建用户失败: " + e.getMessage());
        }
    }
}