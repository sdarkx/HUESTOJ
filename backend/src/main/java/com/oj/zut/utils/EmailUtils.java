// -*- coding = utf-8 -*-
// @Time : 2022/12/6 0006 21:42
// @Author : x_DARK_
// @File : EmailUtils.java
// @Software : IntelliJ IDEA

package com.oj.zut.utils;

import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import com.oj.zut.pojo.email.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailUtils {

    // @Value() 注解应该是springframework中的 ＜（＾－＾）＞ √
    //@Value("${spring.mail.email}")
    //private static String email;
    @Value("${spring.mail.host}")
    private static String host;
    @Value("${spring.mail.port}")
    private static String port;
    @Value("${spring.mail.username}")
    private static String username;
    @Value("${spring.mail.password}")
    private static String password;

    public static void emailSend(Email emailList) {
        // 读取邮箱配置
        if (host == null || port == null || username == null || password == null) {
            throw new RuntimeException("邮箱配置异常");
        }

        // 设置邮箱
        MailAccount account = new MailAccount();
        account.setHost(host);
        account.setPort(Integer.parseInt(port));
        // 设置发送人邮箱
        //account.setFrom(username + "<" + email + ">");
        // 设置发送人名称
        account.setUser(username);
        // 设置发送授权码
        account.setPass(password);
        account.setAuth(true);
        // ssl方式发送
        account.setSslEnable(true);
        // 使用安全连接
        account.setStarttlsEnable(true);

        // 发送邮件
        try {
            int size = emailList.getEmailTu().size();
            Mail.create(account)
                    .setTos(emailList.getEmailTu().toArray(new String[size]))
                    .setTitle(emailList.getSubject())
                    .setContent(emailList.getContent())
                    .setHtml(true)
                    //关闭session
                    .setUseGlobalSession(false)
                    .send();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

