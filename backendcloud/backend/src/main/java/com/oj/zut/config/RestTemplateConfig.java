// -*- coding = utf-8 -*-
// @Time : 2022/12/17 0017 17:57
// @Author : x_DARK_
// @File : RestTemplateConfig.java
// @Software : IntelliJ IDEA

package com.oj.zut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }

}
