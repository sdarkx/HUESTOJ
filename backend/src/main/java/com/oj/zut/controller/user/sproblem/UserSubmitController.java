// -*- coding = utf-8 -*-
// @Time : 2022/12/3 0003 22:06
// @Author : x_DARK_
// @File : UserSubmitController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.user.sproblem;

import com.mysql.cj.conf.url.LoadBalanceDnsSrvConnectionUrl;
import com.oj.zut.pojo.SubmitStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserSubmitController {

    @PostMapping("/user/submit/{task}")
    public Map<String, String> UserSubmit(@RequestParam Map<String, String> data, @PathVariable String task) {
        Map<String, String> map = new HashMap<>();
        /**
         * 作者
         * 题目编号
         * 语言
         * 代码
         */
        String uid = data.get("id");
        String language = data.get("language");
        String demo = data.get("submit_demo");

        /**
         * 提交时间
         */
        Date date = new Date();
        SubmitStatus submit = new SubmitStatus();
        submit.setUId(uid);
        submit.setPID(task);
        submit.setSTime(date);
        submit.setSLanguage(language);
        submit.setSDemo(demo);

        // 调用服务层 然后还有个判题机

        map.put("error_message", "success");
        return map;
    }
}
