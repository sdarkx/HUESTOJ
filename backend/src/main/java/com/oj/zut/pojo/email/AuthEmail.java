// -*- coding = utf-8 -*-
// @Time : 2022/12/6 0006 21:33
// @Author : x_DARK_
// @File : AuthEmail.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo.email;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthEmail {

    /**
     * 发邮件的账户
     * 用户名
     * 密码 ?
     * 临时登陆凭证
     * 邮箱
     */

    private String username;

    private String password;

    private String tempCode;

    private String authEmail ;
}
