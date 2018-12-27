package com.example.lxiao.yummyorder.yummyorder.model.bean;

public class Getstores {
    private int code;
    private String message;

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

    public ObjectBean getObj() {
        return obj;
    }

    public void setObj(ObjectBean obj) {
        this.obj = obj;
    }

    private ObjectBean obj;

    public static class ObjectBean{
        public int num_found;
        public int []storeId;
    }



}
