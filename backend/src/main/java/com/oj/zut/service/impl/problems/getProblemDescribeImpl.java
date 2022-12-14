// -*- coding = utf-8 -*-
// @Time : 2022/12/14 0014 19:21
// @Author : x_DARK_
// @File : getProblemDescribeImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.problems;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.zut.mapper.ProblemsMapper;
import com.oj.zut.pojo.Problem;
import com.oj.zut.service.utils.problems.getProblemDescribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class getProblemDescribeImpl implements getProblemDescribe {

    @Autowired
    private ProblemsMapper problemsMapper;

    @Override
    public Map<String, String> getProblem(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();

        String pb_id = data.get("pb_id");
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pb_id", pb_id);
        Problem problem = problemsMapper.selectOne(queryWrapper);
        map.put("id", problem.getId().toString());
        map.put("pb_id", problem.getPbId());
        map.put("pb_name", problem.getPbName());
        map.put("pb_author", problem.getPbAuthor());
        map.put("pb_describe", problem.getPbDescribe());
        map.put("pb_accepted", problem.getPbAccepted().toString());
        map.put("pb_rating", problem.getPbRating().toString());

        map.put("error_message", "success");
        return map;
    }
}
