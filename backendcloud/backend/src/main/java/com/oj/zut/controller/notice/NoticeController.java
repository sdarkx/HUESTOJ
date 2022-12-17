// -*- coding = utf-8 -*-
// @Time : 2022/12/15 0015 22:05
// @Author : x_DARK_
// @File : NoticeController.java
// @Software : IntelliJ IDEA

package com.oj.zut.controller.notice;


import com.oj.zut.service.utils.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/home/notice/")
    public Map<String, String> getNotice(@RequestParam Map<String, String> map){
        return noticeService.getNotice(map);
    }

}
