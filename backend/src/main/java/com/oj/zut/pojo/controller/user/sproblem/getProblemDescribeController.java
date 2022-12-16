// -*- coding = utf-8 -*-
// @Time : 2022/12/14 0014 19:32
// @Author : x_DARK_
// @File : getProblemDescribeController.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo.controller.user.sproblem;

import com.oj.zut.service.utils.problems.getProblemDescribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class getProblemDescribeController {

    @Autowired
    private getProblemDescribe getProblemDescribe;

    @GetMapping("/problem/getdesc/")
    public Map<String, String> getProblem(@RequestParam Map<String, String> map) {
        return getProblemDescribe.getProblem(map);
    }

}
