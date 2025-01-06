package com.example.elm_rear.service;

import com.example.elm_rear.po.User;
import com.example.elm_rear.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(String userId) {
        return userDao.findByUserId(userId);
    }

    public User createUser(User user) {
        // 设置创建时间
        user.setCreateTime(new Date());
        return userDao.save(user);
    }
}