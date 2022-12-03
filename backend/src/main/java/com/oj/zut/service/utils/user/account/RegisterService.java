// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : RegisterService.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.utils.user.account;

import java.util.Map;

public interface RegisterService {
    Map<String, String> register(String username, String password);
}
