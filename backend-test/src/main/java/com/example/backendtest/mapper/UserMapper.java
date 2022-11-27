package com.example.backendtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backendtest.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
