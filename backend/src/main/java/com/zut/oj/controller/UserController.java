// -*- coding = utf-8 -*-
// @Time : 2022/11/22 0022 17:09
// @Author : x_DARK_
// @File : UserController.java
// @Software : IntelliJ IDEA

package com.zut.oj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 默认情况下，@RestController注解会将返回的对象数据转换为JSON格式。返回数据
 */
@RestController
public class UserController {

    /**
     * 参数name与请求url的name一致时可以直接用 不一致时
     * @RequestParam(value = "name") 加上这一句的话就一定要传递过来参数 否则405
     * json对象传递 注解 @RequestBody
     * 传递对象时，实体类属性名 与 前端传递过来的key-value一直
     * MultipartFile photo 文件上传
     */
    @GetMapping("/user")
    public String enter(@RequestParam(value = "name") String a) {
        return "Hello" + a;
    }

    @RequestMapping("/enter")
    public String user(){
        return "World";
    }
}
