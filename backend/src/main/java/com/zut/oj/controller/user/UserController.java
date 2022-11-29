// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 17:09
// @Author : x_DARK_
// @File : UserController.java
// @Software : IntelliJ IDEA

package com.zut.oj.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zut.oj.mapper.UserMapper;
import com.zut.oj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 默认情况下，@RestController注解会将返回的对象数据转换为JSON格式。返回数据
 */
@Controller
@RestController
public class UserController {

    /**
     * 参数name与请求url的name一致时可以直接用 不一致时
     *
     * @RequestParam(value = "name") 加上这一句的话就一定要传递过来参数 否则405
     * json对象传递 注解 @RequestBody
     * 传递对象时，实体类属性名 与 前端传递过来的key-value一直
     * MultipartFile photo 文件上传
     * @RequestBody 将前端传过来的json对象映射为实体类
     */

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{uId}")
    public String getUser(@PathVariable String uId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id", uId);
        return userMapper.selectOne(queryWrapper).toString();
    }
}
