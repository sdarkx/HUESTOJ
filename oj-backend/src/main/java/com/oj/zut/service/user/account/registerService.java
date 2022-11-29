package com.oj.zut.service.user.account;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface registerService {
    Map<String, String> register(String username, String password, String email);
}
