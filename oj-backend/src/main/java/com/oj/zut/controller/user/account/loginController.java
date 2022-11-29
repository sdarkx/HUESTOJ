// -*- coding = utf-8 -*-
// @Time : 2022/11/29 0029 22:39
// @Author : x_DARK_
// @File : loginController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.user.account;

import com.oj.zut.service.user.account.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class loginController {

    @Autowired
    private loginService loginService;

    @PostMapping("/user/account/token/")
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        // uEmail 标示
        String uEmail = map.get("uEmail");
        String uPassword = map.get("uPassword");
        return loginService.getToken(uEmail, uPassword);
    }
}
