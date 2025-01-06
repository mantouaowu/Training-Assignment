package com.example.elm_rear.po;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Size(min = 11, max = 11, message = "手机号必须是11位")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "请输入有效的手机号")
    private String userId;        // 手机号作为用户ID

    @Size(min = 6, max = 18, message = "密码长度必须在6-18位之间")
    @Column(nullable = false)
    private String password;

    @Column(name = "user_name")
    private String userName;      // 用户姓名

    @Column(name = "user_sex")
    private Integer userSex;      // 性别 0女1男

    @Column(name = "create_time")
    private Date createTime;      // 创建时间

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    // 用于调试
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", createTime=" + createTime +
                '}';
    }
}