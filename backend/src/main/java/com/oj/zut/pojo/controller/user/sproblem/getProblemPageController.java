// -*- coding = utf-8 -*-
// @Time : 2022/12/12 0012 21:23
// @Author : x_DARK_
// @File : getProblemPageController.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo.controller.user.sproblem;

import com.oj.zut.service.utils.problems.getProblemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class getProblemPageController {

    @Autowired
    private getProblemListService getProblemListService;

    //@GetMapping("/problem/list/")
    @RequestMapping(value = "/problem/list/", method = RequestMethod.GET)
    public Map<String, List<Map<String, String>>> getPbPage(@RequestParam Map<String, String> map) {
        
        if (map.get("current_page").equals("0") || map.get("page_size").equals("0")) {
            Map<String, List<Map<String, String>>> a = new HashMap<>();
            List<Map<String, String>> b = new ArrayList<>();
            Map<String, String> c = new HashMap<>();
            c.put("error_message", "请求错误");
            b.add(c);
            a.put("error_message", b);
            return a;
        }

        return getProblemListService.getProblems(map);
    }

}
