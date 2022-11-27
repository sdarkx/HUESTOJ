// -*- coding = utf-8 -*-
// @Time : 2022/11/27 0027 15:01
// @Author : x_DARK_
// @File : Result.java
// @Software : IntelliJ IDEA

package com.zut.oj.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 泛型多种返回数据包装
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private String error_code;
    private String error_msg;
    private T data;

    public static Result success() {
        Result result = new Result<>();
        result.setError_code("798");
        result.setError_msg("success");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setError_code("798");
        result.setError_msg("success");
        return result;
    }

    public static Result success(String error_code, String error_msg) {
        Result result = new Result();
        result.setError_code(error_code);
        result.setError_msg(error_msg);
        return result;
    }
}
