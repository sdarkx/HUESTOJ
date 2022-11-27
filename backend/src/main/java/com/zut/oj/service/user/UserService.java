// -*- coding = utf-8 -*-
// @Time : 2022/11/27 0027 20:11
// @Author : x_DARK_
// @File : UserService.java
// @Software : IntelliJ IDEA

package com.zut.oj.service.user;

import com.zut.oj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

}
