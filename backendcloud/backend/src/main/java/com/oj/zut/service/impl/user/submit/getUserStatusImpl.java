// -*- coding = utf-8 -*-
// @Time : 2022/12/21 0021 14:20
// @Author : x_DARK_
// @File : getUserStatusImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.submit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.zut.mapper.UserStatusMapper;
import com.oj.zut.pojo.SubmitStatus;
import com.oj.zut.pojo.User;
import com.oj.zut.service.utils.UserDetailsImpl;
import com.oj.zut.service.utils.user.submit.getUserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class getUserStatusImpl implements getUserStatus {

    @Autowired
    private UserStatusMapper userStatusMapper;

    @Override
    public List<Map<String, String>> getUserStatus(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        QueryWrapper<SubmitStatus> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_user_id", user.getId());
        queryWrapper.select().orderByDesc("id");
        queryWrapper.last("limit 30");

        List<SubmitStatus> submitStatuses = userStatusMapper.selectList(queryWrapper);

        List<Map<String, String>> res = new ArrayList<>();

        for (int i = 0; i < submitStatuses.size(); i++) {
            Map<String, String> te = new HashMap<>();
            te.put("id", submitStatuses.get(i).getId().toString());
            te.put("when", submitStatuses.get(i).getSTime().toString());
            te.put("who", user.getUNickname());
            te.put("problem", submitStatuses.get(i).getSPbId());
            te.put("lang", submitStatuses.get(i).getSLang());
            te.put("verdict", submitStatuses.get(i).getSVerdict());
            te.put("time", submitStatuses.get(i).getSRunTime());
            te.put("memory", submitStatuses.get(i).getSRunMemory());
            res.add(te);
        }

        return res;
    }
}
