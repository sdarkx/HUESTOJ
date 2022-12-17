// -*- coding = utf-8 -*-
// @Time : 2022/12/12 0012 19:53
// @Author : x_DARK_
// @File : ProblemsMapper.java
// @Software : IntelliJ IDEA

package com.oj.zut.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oj.zut.pojo.Problem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProblemsMapper extends BaseMapper<Problem> {
}
