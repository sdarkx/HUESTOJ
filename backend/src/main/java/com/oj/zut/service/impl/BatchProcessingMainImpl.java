// -*- coding = utf-8 -*-
// @Time : 2022/12/7 0007 19:20
// @Author : x_DARK_
// @File : BatchProcessingMainImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl;

import com.oj.zut.service.utils.BatchProcessingMail;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BatchProcessingMainImpl implements BatchProcessingMail {

    @Override
    public Map<String, String> BatchSendEmail(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();

        // TODO 发送邮件

        map.put("error_massage", "success");
        return map;
    }

}
