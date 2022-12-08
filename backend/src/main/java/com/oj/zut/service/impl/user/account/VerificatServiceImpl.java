// -*- coding = utf-8 -*-
// @Time : 2022/12/6 0006 21:13
// @Author : x_DARK_
// @File : VerificatServiceImpl.java
// @Software : IntelliJ IDEA

package com.oj.zut.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oj.zut.mapper.UserMapper;
import com.oj.zut.pojo.User;
import com.oj.zut.service.utils.user.account.VerificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

@Service
public class VerificatServiceImpl implements VerificatService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> VerificatCode(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        String username = data.get("username");

        /**
         *   正则表达式实用规则
         *   ^匹配输入字符串的开始位置
         *   $结束的位置
         *   \转义字符 eg:\. 匹配一个. 字符  不是任意字符 ，转义之后让他失去原有的功能
         *   \t制表符
         *   \n换行符
         *   \\w匹配字符串  eg:\w不能匹配 因为转义了
         *   \w匹配包括字母数字下划线的任何单词字符
         *   \s包括空格制表符换行符
         *   *匹配前面的子表达式任意次
         *   .小数点可以匹配任意字符
         *   +表达式至少出现一次
         *   ?表达式0次或者1次
         *   {10}重复10次
         *   {1,3}至少1-3次
         *   {0,5}最多5次
         *   {0,}至少0次 不出现或者出现任意次都可以 可以用*号代替
         *   {1,}至少1次  一般用+来代替
         *   []自定义集合     eg:[abcd]  abcd集合里任意字符
         *   [^abc]取非 除abc以外的任意字符
         *   |  将两个匹配条件进行逻辑“或”（Or）运算
         *   [1-9] 1到9 省略123456789
         *    邮箱匹配 eg: ^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\.){1,3}[a-zA-z\-]{1,}$
         *
         */
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(username);
        //进行正则匹配
        if (!m.matches()) {
            map.put("error_message", "请输入账号");
            return map;
        }

        // TODO 查验当前账号是否已经注册
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_username", username);

        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "账户已存在");
            return map;
        }
        // TODO 生成随机数 -> 数据库 -> 调用BatchSendProcessingImpl


        map.put("error_message", "success");
        return map;
    }

}
