// -*- coding = utf-8 -*-
// @Time : 2022/12/17 0017 16:25
// @Author : x_DARK_
// @File : CodeRunnerSystemApplication.java
// @Software : IntelliJ IDEA

package com.oj.zut.coderunnersystem;

import com.oj.zut.coderunnersystem.service.Impl.CodeRunningServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeRunnerSystemApplication {
    public static void main(String[] args) {
        CodeRunningServiceImpl.code_pool.start();
        SpringApplication.run(CodeRunnerSystemApplication.class, args);
    }
}
