// -*- coding = utf-8 -*-
// @Time : 2022/12/17 0017 18:00
// @Author : x_DARK_
// @File : WebSocketServe.java
// @Software : IntelliJ IDEA

package com.oj.zut.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/websocket/")
public class WebSocketServe {

    private static RestTemplate restTemplate;

    private final static String addCodeUrl = "http://127.0.0.1:8092/code/runner/";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        WebSocketServe.restTemplate = restTemplate;
    }

    @OnMessage
    public static void onMessage(String code) {  // 当做路由
        System.out.println("receive message!");

        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();

        data.add("id", "123123");
        data.add("code", code);

        restTemplate.postForObject(addCodeUrl, data, String.class);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
