// -*- coding = utf-8 -*-
// @Time : 2022/12/17 0017 18:00
// @Author : x_DARK_
// @File : WebSocketServe.java
// @Software : IntelliJ IDEA

package com.oj.zut.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WebSocketServe {

    private static RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        WebSocketServe.restTemplate = restTemplate;
    }

}
