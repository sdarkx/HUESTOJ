// -*- coding = utf-8 -*-
// @Time : 2022/12/3 0003 22:22
// @Author : x_DARK_
// @File : UserSubmitImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.submit;

import com.oj.zut.consumer.WebSocketServe;
import com.oj.zut.mapper.UserSubmitMapper;
import com.oj.zut.pojo.SubmitStatus;
import com.oj.zut.service.utils.user.submit.UserSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserSubmitImpl implements UserSubmit {

    @Autowired
    private UserSubmitMapper userSubmitMapper;

    @Override
    public Map<String, String> UserSubmitDemo(SubmitStatus submitStatus) {
        Map<String, String> map = new HashMap<>();
        userSubmitMapper.insert(submitStatus);

        // 插入数据库 评测 结果返回后 up数据库
        // TODO
        // WebSocketServe.onMessage();

        map.put("error_message", "submit success!");
        return map;
    }
}
