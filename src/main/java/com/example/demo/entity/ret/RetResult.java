package com.example.demo.entity.ret;

import java.util.List;


public class RetResult<T> {

    private int code;

    private String msg;

    private List<T> data;


    public List<T> getData() {
        return data;
    }

    public RetResult<T> setData(List<T> data) {
        this.data = data;
        return this;
    }


    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }


    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

}
