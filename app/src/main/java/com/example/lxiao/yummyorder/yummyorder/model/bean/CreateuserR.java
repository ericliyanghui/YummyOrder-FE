package com.example.lxiao.yummyorder.yummyorder.model.bean;

public class CreateuserR {
    private int code;
    private String message;
    private ObjectU obj;
    public static class ObjectU{
        String username;
        int id;
        String rolename;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ObjectU getObj() {
        return obj;
    }

    public void setObj(ObjectU obj) {
        this.obj = obj;
    }
}
