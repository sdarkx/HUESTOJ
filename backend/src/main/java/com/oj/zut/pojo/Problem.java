// -*- coding = utf-8 -*-
// @Time : 2022/12/12 0012 16:47
// @Author : x_DARK_
// @File : Problem.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "problems")
public class Problem {

    // 数据库自增
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String pbId;
    private String pbName; // 题目名字
    private Integer pbLimTime; // 时间限制
    private Integer pbLimMemory; // 空间限制
    private String pbDescribe; // 题目描述
    private String pbIn; // 输入格式
    private String pbOut; // 输出格式
    private String pbDataRange; // 数据范围
    private String pbSimpleIn; // 样例输入
    private String pbSimpleOut; // 样例输出

    private Integer pbRating;
    private Integer pbAccepted;
    private String pbAuthor;
    private String pbSource;
    private Integer pbIsopen; // 暂时没用

}
