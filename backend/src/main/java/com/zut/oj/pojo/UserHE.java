// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : UserHE.java
// @Software : IntelliJ IDEA

package com.zut.oj.pojo;

import lombok.Data;

@Data
public class UserHE {
    private String uId; // 唯一标识符 qq邮箱注册截取qq号为uid
    private String nickname; // 用户名 昵称
    private String password; //pwd
    private String email; // 电子邮箱
    private String uStuId; // 学号
    private String uRealName; // 姓名
    private Integer uRating;
}
