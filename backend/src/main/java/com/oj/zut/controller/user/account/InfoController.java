package com.oj.zut.controller.user.account;

import com.oj.zut.service.impl.utils.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/user/account/info/")
    public Map<String, String> getInfo() {
        return infoService.getinfo();
    }
}
