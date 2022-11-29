package com.oj.zut.service.user.account;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface loginService {
    Map<String, String> getToken(String uEmail, String uPassword);
}
