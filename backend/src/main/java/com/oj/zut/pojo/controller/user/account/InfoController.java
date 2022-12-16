// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : InfoController.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo.controller.user.account;

import com.oj.zut.service.utils.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    //@CrossOrigin(origins = "http://localhost:8091/user/account/info/", maxAge = 3600)
    @GetMapping("/user/account/info/")
    public Map<String, String> getInfo() {
        return infoService.getinfo();
    }
}
