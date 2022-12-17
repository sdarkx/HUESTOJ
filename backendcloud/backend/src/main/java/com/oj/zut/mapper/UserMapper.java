// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 13:38
// @Author : x_DARK_
// @File : UserMapper.java
// @Software : IntelliJ IDEA

package com.oj.zut.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oj.zut.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
