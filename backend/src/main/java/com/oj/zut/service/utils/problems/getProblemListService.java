// -*- coding = utf-8 -*-
// @Time : 2022/12/12 0012 16:55
// @Author : x_DARK_
// @File : getProblemListService.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.utils.problems;

import java.util.List;
import java.util.Map;

public interface getProblemListService {
    Map<String, List<Map<String, String>>> getProblems(Map<String, String> map);
}
