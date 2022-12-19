// -*- coding = utf-8 -*-
// @Time : 2022/12/19 0019 12:39
// @Author : x_DARK_
// @File : CodeRunningService.java
// @Software : IntelliJ IDEA

package com.oj.zut.coderunnersystem.service;

import org.springframework.util.MultiValueMap;

import java.util.Map;

public interface CodeRunningService {
    Map<String, String> codeRunner(MultiValueMap<String, String> map);
}
