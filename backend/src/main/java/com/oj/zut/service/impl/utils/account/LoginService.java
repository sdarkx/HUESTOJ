package com.oj.zut.service.impl.utils.account;

import java.util.Map;

public interface LoginService {
    public Map<String, String> getToken(String username, String password);
}
