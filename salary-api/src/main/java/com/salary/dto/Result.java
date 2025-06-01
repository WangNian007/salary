package com.salary.dto;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> failed(String message) {
        Result<T> result = new Result<>();
        result.setCode(500); // 或者自定义错误码
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200); // 或者自定义错误码
        result.setData(data);
        return result;
    }

    public static <T> Result<T> redirectLogin(String message) {
        Result<T> result = new Result<>();
        result.setCode(401); // 或者自定义错误码
        result.setData(null);
        return result;
    }
}
