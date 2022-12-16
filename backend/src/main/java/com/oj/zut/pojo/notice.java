// -*- coding = utf-8 -*-
// @Time : 2022/12/15 0015 21:33
// @Author : x_DARK_
// @File : notice.java
// @Software : IntelliJ IDEA

package com.oj.zut.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "notice")
public class notice {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String ntTitle;
    /**
     * 时间格式 及时区问题
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ntTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ntUpTime;
    private String ntText;
    private Integer ntCount;

}
