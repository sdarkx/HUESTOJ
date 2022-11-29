// -*- coding = utf-8 -*-
// @Time : 2022/11/29 0029 22:28
// @Author : x_DARK_
// @File : loginServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.acount;

import com.oj.zut.pojo.User;
import com.oj.zut.service.impl.utils.UserDetailsImpl;
import com.oj.zut.service.user.account.loginService;
import com.oj.zut.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.Map;

public class loginServiceImpl implements loginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String uEmail, String uPassword) {
        // 封装加密
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(uEmail, uPassword);
        // 判断当前用户是否登录
        Authentication authenticate =
                authenticationManager.authenticate(usernamePasswordAuthenticationToken); // 登陆失败自动处理

        UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getAuthorities();

        // 当前用户
        User user = userDetails.getUser();

        // 封装成jwt token
        String jwt = JwtUtil.createJWT(user.getUId());
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("token", jwt);
        return map;
    }

}
