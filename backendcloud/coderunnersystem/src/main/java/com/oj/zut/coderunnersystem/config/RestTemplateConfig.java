// -*- coding = utf-8 -*-
// @Time : 2022/12/19 0019 12:52
// @Author : x_DARK_
// @File : RestTemplateConfig.java
// @Software : IntelliJ IDEA

package com.oj.zut.coderunnersystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

