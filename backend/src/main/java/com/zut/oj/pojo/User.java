// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : User.java
// @Software : IntelliJ IDEA

package com.zut.oj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer Id;
    private String uId; // 唯一标识符 qq邮箱注册截取qq号为uid
    private String uNickname; // 用户名 昵称
    private String uPassword; //pwd
    private String uEmail; // 电子邮箱
    private String uStuId; // 学号
    private String uRealName; // 姓名
    private Integer uRating; // rating

}
