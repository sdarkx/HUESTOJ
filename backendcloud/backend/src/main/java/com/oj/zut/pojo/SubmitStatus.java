// -*- coding = utf-8 -*-
// @Time : 2022/12/3 0003 22:25
// @Author : x_DARK_
// @File : SubmitStatus.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitStatus {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String uId;
    private String pID;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sTime;
    private String sLanguage;
    private String sDemo;
    // null
    private String sStatus;
    private String sRuntime;
    private String sRunmemory;

}
