// -*- coding = utf-8 -*-
// @Time : 2022/12/17 0017 17:46
// @Author : x_DARK_
// @File : CodeRunningController.java
// @Software : IntelliJ IDEA

package com.oj.zut.coderunnersystem.controler;

import com.oj.zut.coderunnersystem.service.CodeRunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CodeRunningController {

    @Autowired
    private CodeRunningService codeRunningService;

    @PostMapping("/code/runner/")
    public Map<String, String> codeRunner(@RequestParam MultiValueMap<String, String> data) {
        return codeRunningService.codeRunner(data);
    }
}
