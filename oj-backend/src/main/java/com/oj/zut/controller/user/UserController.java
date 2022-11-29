// -*- coding = utf-8 -*-
// @Time : 2022/11/29 0029 21:11
// @Author : x_DARK_
// @File : UserController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.user;

import com.oj.zut.mapper.UserMapper;
import com.oj.zut.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/all")
    public List<User> getAll() {
        return userMapper.selectList(null);
    }

    @GetMapping("/add/user/{uid}/{username}/{upwd}/{uemail}")
    public String addUser(@PathVariable String uid, @PathVariable String username, @PathVariable String upwd, @PathVariable String uemail) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setUId(uid);
        user.setUUsername(username);
        user.setUPassword(passwordEncoder.encode(upwd));
        user.setUEmail(uemail);
        userMapper.insert(user);
        return "Add user successfully";
    }
}
