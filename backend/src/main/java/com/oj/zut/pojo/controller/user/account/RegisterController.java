// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : RegisterController.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo.controller.user.account;


import com.oj.zut.service.utils.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/user/account/register/")
    public Map<String, String> register(@RequestParam Map<String, String> map) {
        return registerService.register(map);
    }
}
