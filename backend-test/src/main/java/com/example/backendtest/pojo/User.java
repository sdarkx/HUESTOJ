// -*- coding = utf-8 -*-
// @Time : 2022/11/27 0027 19:32
// @Author : x_DARK_
// @File : User.java
// @Software : IntelliJ IDEA

package com.example.backendtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
}
