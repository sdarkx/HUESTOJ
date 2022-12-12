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
    private String pbName;
    private String pbDescribe;
    private Integer pbLimTime;
    private Integer pbLimMemory;
    private String pbAuthor;
    private String pbSource;
    private Integer pbIsopen;
    private Integer pbRating;
    private Integer pbAccepted;

}
