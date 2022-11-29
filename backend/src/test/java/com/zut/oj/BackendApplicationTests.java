package com.zut.oj;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zut.oj.mapper.UserMapper;
import com.zut.oj.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
class BackendApplicationTests {

    @Test
    void test1() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("a"));
    }

    @Test
    void test2(){

    }
}
