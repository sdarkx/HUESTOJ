// -*- coding = utf-8 -*-
// @Time : 2022/11/27 0027 19:59
// @Author : x_DARK_
// @File : UserService.java
// @Software : IntelliJ IDEA

package com.example.backendtest.service;

import com.example.backendtest.mapper.UserMapper;
import com.example.backendtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.selectList(null);
    }
}
