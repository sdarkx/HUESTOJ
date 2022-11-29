package com.oj.zut.service.user.account;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface infoService {
    Map<String, String> getInfo();
}
