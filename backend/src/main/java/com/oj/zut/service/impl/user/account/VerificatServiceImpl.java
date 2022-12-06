// -*- coding = utf-8 -*-
// @Time : 2022/12/6 0006 21:13
// @Author : x_DARK_
// @File : VerificatServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.account;


import com.oj.zut.pojo.email.Email;
import com.oj.zut.service.utils.user.account.VerificatService;
import com.oj.zut.utils.EmailUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VerificatServiceImpl implements VerificatService {

    @Override
    public Map<String, String> VerificatCode(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        String username = data.get("username");

        if(username == null){
            map.put("error_message", "请输入账号");
            return map;
        }

        Email email = new Email();
        List<String> list = new ArrayList<>();
        list.add(username);
        email.setEmailTu(list);
        email.setSubject("HUEST Online Judge");
        email.setContent("账号注册");
        EmailUtils.emailSend(email);

        map.put("error_message", "success");
        return map;
    }

}
