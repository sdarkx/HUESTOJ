// -*- coding = utf-8 -*-
// @Time : 2022/12/6 0006 21:13
// @Author : x_DARK_
// @File : VerificatServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.account;

import com.oj.zut.service.utils.user.account.VerificatService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificatServiceImpl implements VerificatService {

    @Override
    public Map<String, String> VerificatCode(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        String username = data.get("username");



        map.put("error_message", "success");
        return map;
    }

}
