// -*- coding = utf-8 -*-
// @Time : 2022/12/3 0003 22:06
// @Author : x_DARK_
// @File : UserSubmitController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.user.sproblem;

import com.oj.zut.pojo.SubmitStatus;
import com.oj.zut.service.utils.user.account.InfoService;
import com.oj.zut.service.utils.user.submit.UserSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserSubmitController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserSubmit userSubmit;

    @PostMapping("/user/submit/")
    public Map<String, String> UserSubmit(@RequestParam Map<String, String> data) {
        Map<String, String> map = new HashMap<>();

        //Map<String, String> getinfo = infoService.getinfo();
        //String uid = getinfo.get("id"); // a
        String uid = data.get("uid");
        String pid = data.get("pb_id"); // q
        String lang = data.get("language"); // lang
        String demo = data.get("demo"); // demo

        SubmitStatus submit = new SubmitStatus();
        submit.setSUserId(uid);
        submit.setSPbId(pid);
        submit.setSTime(new Date());
        submit.setSLang(lang);
        submit.setSDemo(demo);
        submit.setSVerdict("Pending");


        System.out.println("submit : " + submit);
        // 调用服务层评测
        //return userSubmit.UserSubmitDemo(submit);
        map.put("error_message", "success");
        return map;
    }
}
