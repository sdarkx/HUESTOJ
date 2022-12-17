// -*- coding = utf-8 -*-
// @Time : 2022/12/12 0012 16:57
// @Author : x_DARK_
// @File : getProblemListServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.problems;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.zut.mapper.ProblemsMapper;
import com.oj.zut.pojo.Problem;
import com.oj.zut.service.utils.problems.getProblemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class getProblemListServiceImpl implements getProblemListService {

    @Autowired
    private ProblemsMapper problemsMapper;

    @Override
    public Map<String, List<Map<String, String>>> getProblems(Map<String, String> data) {
        Map<String, List<Map<String, String>>> map = new HashMap<>();

        int current_page = Integer.parseInt(data.get("current_page"));
        int page_size = Integer.parseInt(data.get("page_size"));

        IPage<Problem> page = new Page<>(current_page, page_size);
        QueryWrapper<Problem> problemQueryWrapper = new QueryWrapper<>();
        problemQueryWrapper.select(
                "id",
                "pb_id",
                "pb_name",
                "pb_rating",
                "pb_accepted"
        );

        IPage<Problem> problemIPage = problemsMapper.selectPage(page, problemQueryWrapper);

        // 封装题目列表
        List<Map<String, String>> pb_li = new ArrayList<>();
        List<Problem> problemList = problemIPage.getRecords();
        for (Problem problem : problemList) {
            Map<String, String> temp = new HashMap<>();
            temp.put("id", String.valueOf(problem.getId()));
            temp.put("pb_id", problem.getPbId());
            temp.put("pb_name", problem.getPbName());
            temp.put("pb_rating", String.valueOf(problem.getPbRating()));
            temp.put("pb_accepted", String.valueOf(problem.getPbAccepted()));
            pb_li.add(temp);
        }
        map.put("problems_list", pb_li);

        // 封装页面展示
        List<Map<String, String>> pg_li = new ArrayList<>();
        Map<String, String> temp2 = new HashMap<>();
        temp2.put("total", String.valueOf(problemIPage.getTotal())); // 总条数
        temp2.put("pages", String.valueOf(problemIPage.getPages())); // 总页数
        temp2.put("current", String.valueOf(problemIPage.getCurrent())); // 当前页数
        temp2.put("size", String.valueOf(problemIPage.getSize())); // 每页条数
        pg_li.add(temp2);
        map.put("page_list", pg_li);

        // 封装错误信息
        List<Map<String, String>> er_li = new ArrayList<>();
        Map<String, String> temp3 = new HashMap<>();
        temp3.put("error_message", "success");
        er_li.add(temp3);
        map.put("error_message", er_li);
        return map;
    }

}
