// -*- coding = utf-8 -*-
// @Time : 2022/12/7 0007 19:10
// @Author : x_DARK_
// @File : Verificat.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "verificat")
public class Verificat {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String verificat;
    private Date date;

}