// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : LoginServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.account;

import com.oj.zut.mapper.UserMapper;
import com.oj.zut.pojo.User;
import com.oj.zut.service.utils.UserDetailsImpl;
import com.oj.zut.service.utils.user.account.LoginService;
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
    public Map<String, String> getToken(String u_username, String u_password) {
        //System.out.println("Before : loginServiceImpl : " + u_username + " + " + u_password);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(u_username, u_password);

        //System.out.println("authenticationToken : " + authenticationToken);

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);  // 登录失败，会自动处理

        //System.out.println("authenticate : " + authenticate);

        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user = loginUser.getUser();

        //System.out.println("Services user : " + user);

        String jwt = JwtUtil.createJWT(user.getId().toString());

        //QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("u_username", username);
        //queryWrapper.eq("u_password", password);
        //userMapper.selectOne(queryWrapper);

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("token", jwt);

        //System.out.println("After : loginServiceImpl : " + u_username + " + " + u_password);

        return map;
    }
}
