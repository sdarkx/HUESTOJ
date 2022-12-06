// -*- coding = utf-8 -*-
// @Time : 2022/12/6 0006 21:05
// @Author : x_DARK_
// @File : VerificatController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.user.account;

import com.oj.zut.service.utils.user.account.VerificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class VerificatController {

    @Autowired
    private VerificatService verificatService;

    @PostMapping("/user/account/get_verification_code/")
    public Map<String, String> get_verification_code(@RequestParam Map<String, String> data) {
        return verificatService.VerificatCode(data);
    }

}
