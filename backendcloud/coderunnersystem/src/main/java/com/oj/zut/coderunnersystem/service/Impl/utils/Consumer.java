// -*- coding = utf-8 -*-
// @Time : 2022/12/19 0019 14:27
// @Author : x_DARK_
// @File : Consumer.java
// @Software : IntelliJ IDEA

package com.oj.zut.coderunnersystem.service.Impl.utils;

import com.oj.zut.coderunnersystem.utils.CodeInterface;
import org.joor.Reflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class Consumer extends Thread {

    private CodeA code;
    private static RestTemplate restTemplate;

    private final static String receiveResultUrl = "http://127.0.0.1:3000/code/result/";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        Consumer.restTemplate = restTemplate;
    }

    public void startTimeOut(Integer timeout, CodeA code) {
        this.code = code;
        this.start();

        try {
            this.join(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }

    //private String fixUid(String code, String uid) {  // 在code中的Bot类名后添加uid
    //    int k = code.indexOf("(){"); // implements com.oj.zut.coderunnersystem.utils.CodeInterface
    //    return code.substring(0, k) + uid + code.substring(k);
    //}

    @Override
    public void run() {
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString().substring(0, 8);

        // "com.oj.zut.coderunnersystem.utils.code" +
        CodeInterface codeInterface = Reflect.compile(
                "Main",
                code.getCode()
        ).create().get();

        String result = codeInterface.result();

        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();

        data.add("result", result);
        data.add("ret", "Accept");

        System.out.println("[==data==] : " + data);

        restTemplate.postForObject(receiveResultUrl, data, String.class);
    }
}
