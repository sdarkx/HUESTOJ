// -*- coding = utf-8 -*-
// @Time : 2022/12/15 0015 21:42
// @Author : x_DARK_
// @File : NoticeServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.notice;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oj.zut.mapper.NoticeMapper;
import com.oj.zut.pojo.notice;
import com.oj.zut.service.utils.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Map<String, String> getNotice(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();

        int current_page = Integer.parseInt(data.get("current_page"));
        IPage<notice> page = new Page<>(current_page, 1);
        QueryWrapper<notice> noticeQueryWrapper = new QueryWrapper<>();
        noticeQueryWrapper.select().orderByDesc("id");
        IPage<notice> noticeIPage = noticeMapper.selectPage(page, noticeQueryWrapper);
        // 封装文章
        List<notice> records = noticeIPage.getRecords();
        for(notice no : records){
            map.put("id", no.getId().toString());
            map.put("nt_title", no.getNtTitle());
            map.put("nt_author", no.getNtAuthor());
            map.put("nt_time", no.getNtTime().toString());
            map.put("nt_up_time", no.getNtUpTime().toString());
            map.put("nt_text", no.getNtText());
            map.put("nt_count", no.getNtCount().toString());
        }
        // 封装总记录数
        map.put("total", String.valueOf(noticeIPage.getTotal()));

        map.put("error_message", "success");
        return map;
    }

}
