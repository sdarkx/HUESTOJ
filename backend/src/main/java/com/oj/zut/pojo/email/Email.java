// -*- coding = utf-8 -*-
// @Time : 2022/12/6 0006 21:29
// @Author : x_DARK_
// @File : Email.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    /**
     * 发送邮箱列表
     * 使用List为以后方便网站后台管理统一发邮件使用
     */
    private List<String> emailTu;

    /**
     * 邮件统一主题
     */
    private String subject;

    /**
     * 统一的邮件内容
     */
    private String content;
}
