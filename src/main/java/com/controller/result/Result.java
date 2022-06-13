package com.controller.result;

public class Result {
    private Object data1;
    private Integer code;
    private String msg;


    public Result(Integer code,Object data,  String msg) {
        this.data1 = data;
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public Result(Integer code,Object data) {
        this.data1 = data;
        this.code = code;
    }

    public Object getData() {
        return data1;
    }

    public void setData(Object data) {
        this.data1 = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
