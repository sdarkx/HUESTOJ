// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : LoginServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.zut.mapper.UserMapper;
import com.oj.zut.pojo.User;
import com.oj.zut.service.impl.utils.UserDetailsImpl;
import com.oj.zut.service.impl.utils.account.LoginService;
import com.oj.zut.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> getToken(String username, String password) {
        System.out.println("Before : loginServiceImpl : " + username + " + " + password);

        //UsernamePasswordAuthenticationToken authenticationToken =
        //        new UsernamePasswordAuthenticationToken(username, password);
        //
        //Authentication authenticate = authenticationManager.authenticate(authenticationToken);  // 登录失败，会自动处理
        //UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        //User user = loginUser.getUser();
        //
        //System.out.println("Services user : " + user);
        //
        //String jwt = JwtUtil.createJWT(user.getId().toString());

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username", username);
        queryWrapper.eq("u_password", password);
        userMapper.selectOne(queryWrapper);

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        //map.put("token", jwt);

        System.out.println("After : loginServiceImpl : " + username + " + " + password);

        return map;
    }
}
