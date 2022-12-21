// -*- coding = utf-8 -*-
// @Time : 2022/12/21 0021 13:15
// @Author : x_DARK_
// @File : UserStatusController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.user.sproblem;

import com.oj.zut.service.utils.user.submit.getUserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserStatusController {

    @Autowired
    private getUserStatus getUserStatus;

    @PostMapping("/user/status/")
    public List<Map<String, String>> getUserStatus(@RequestParam Map<String, String> data) {
        return getUserStatus.getUserStatus(data);
    }
}
