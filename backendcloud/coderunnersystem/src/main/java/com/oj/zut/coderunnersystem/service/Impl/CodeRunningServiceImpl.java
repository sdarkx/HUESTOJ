// -*- coding = utf-8 -*-
// @Time : 2022/12/19 0019 12:41
// @Author : x_DARK_
// @File : CodeRunningServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.coderunnersystem.service.Impl;

import com.oj.zut.coderunnersystem.service.CodeRunningService;
import com.oj.zut.coderunnersystem.service.Impl.utils.CodePool;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodeRunningServiceImpl implements CodeRunningService {

    public final static CodePool code_pool = new CodePool();

    @Override
    public Map<String, String> codeRunner(MultiValueMap<String, String> data) {
        Map<String, String> map = new HashMap<>();

        //String id = data.getFirst("id");
        //String code = data.getFirst("code");

        code_pool.addCode(data);

        map.put("error_message", "submit success");
        return map;
    }

}
