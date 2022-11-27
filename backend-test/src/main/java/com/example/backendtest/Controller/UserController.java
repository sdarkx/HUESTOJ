// -*- coding = utf-8 -*-
// @Time : 2022/11/27 0027 19:33
// @Author : x_DARK_
// @File : UserController.java
// @Software : IntelliJ IDEA

package com.example.backendtest.Controller;

import com.example.backendtest.mapper.UserMapper;
import com.example.backendtest.pojo.User;
import com.example.backendtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/all")
    public List<User> getAll(){
        return userService.getAll();
    }
}
