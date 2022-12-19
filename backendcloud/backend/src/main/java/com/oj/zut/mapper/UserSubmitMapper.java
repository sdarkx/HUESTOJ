// -*- coding = utf-8 -*-
// @Time : 2022/12/19 0019 13:37
// @Author : x_DARK_
// @File : UserSubmitMapper.java
// @Software : IntelliJ IDEA

package com.oj.zut.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oj.zut.pojo.SubmitStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSubmitMapper extends BaseMapper<SubmitStatus> {
}
