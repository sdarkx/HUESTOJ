// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : RegisterServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.zut.mapper.UserMapper;
import com.oj.zut.pojo.User;
import com.oj.zut.service.utils.user.account.RegisterService;
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
    public Map<String, String> register(Map<String, String> data) {
        User user = new User();
        user.setUUsername(data.get("username"));
        user.setUPassword(data.get("password"));
        user.setUNickname(data.get("nickname"));
        user.setURealname(data.get("realname"));
        user.setUStuid(data.get("userstuid"));
        user.setURating(0);

        Map<String, String> map = new HashMap<>();

        String checkPass = data.get("checkPass");
        if(!user.getUPassword().equals(checkPass)){
            map.put("error_message", "两次密码不一致");
            return map;
        }

        // 核验用户名是否合规
        // 前端校验防君子 后端校验防小人

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username", user.getUUsername());

        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "账户已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(user.getUPassword());
        user.setUPassword(encodedPassword);

        userMapper.insert(user);

        map.put("error_message", "success");
        return map;
    }
}
