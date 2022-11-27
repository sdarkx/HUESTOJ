// -*- coding = utf-8 -*-
// @Time : 2022/11/27 0027 17:53
// @Author : x_DARK_
// @File : UserMapper.java
// @Software : IntelliJ IDEA

package com.zut.oj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zut.oj.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
