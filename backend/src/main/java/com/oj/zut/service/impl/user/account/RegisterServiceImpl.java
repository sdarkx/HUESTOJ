// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : RegisterServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.zut.mapper.UserMapper;
import com.oj.zut.pojo.User;
import com.oj.zut.service.impl.utils.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password) {
        Map<String, String> map = new HashMap<>();

        // 用户名去空格
        username = username.trim();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);

        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setUUsername(username);
        user.setUPassword(encodedPassword);
        userMapper.insert(user);

        map.put("error_message", "success");
        return map;
    }
}
