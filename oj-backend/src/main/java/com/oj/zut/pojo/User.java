// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : User.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User {

    // 数据库自增
    @TableId(value = "id", type = IdType.AUTO)
    private Integer Id;
    private String uId; // 用户名 唯一标识符 qq邮箱注册截取qq号为uid
    // UserDetailsImpl
    private String uUsername; //  用户名 唯一把 后边再改 昵称
    private String uPassword; //pwd
    private String uEmail; // 电子邮箱
    private String uStuid; // 学号
    private String uRealname; // 姓名
    private Integer uRating; // rating

}
