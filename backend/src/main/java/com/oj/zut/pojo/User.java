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
    private String uUsername;
    private String uPassword;
    private String uNickname;
    private String uRealname;
    private String uStuid;
    private Integer uRating;

}
