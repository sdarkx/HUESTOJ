// -*- coding = utf-8 -*-
// @Time : 2022/12/12 0012 21:23
// @Author : x_DARK_
// @File : getProblemPageController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.user.sproblem;

import com.oj.zut.service.utils.problems.getProblemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class getProblemPageController {

    @Autowired
    private getProblemListService getProblemListService;

    @GetMapping("/problem/list/")
    public Map<String, List<Map<String, String>>> getPbPage(@RequestParam Map<String, String> map) {
        return getProblemListService.getProblems(map);
    }

}
