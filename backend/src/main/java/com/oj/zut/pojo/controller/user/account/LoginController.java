// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : LoginController.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo.controller.user.account;

import com.oj.zut.service.utils.user.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    //@CrossOrigin(origins = "http://localhost:8091/user/account/token/", maxAge = 3600)
    @PostMapping("/user/account/token/")
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");

        //System.out.println(username + ' ' + password);

        return loginService.getToken(username, password);
    }
}
