// -*- coding = utf-8 -*-
// @Time : 2022/11/29 0029 21:08
// @Author : x_DARK_
// @File : UserDetailsServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.zut.mapper.UserMapper;
import com.oj.zut.pojo.User;
import com.oj.zut.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        return new UserDetailsImpl(user);
    }
}

