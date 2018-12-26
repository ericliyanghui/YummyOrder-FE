package com.example.lxiao.yummyorder.yummyorder.gson;

public class GetStores {
    private int code;
    private String message;
    private ObjectBean obj;

    public static class ObjectBean{
        private int num_found;
        private int []storeId;
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

    public ObjectBean getObj() {
        return obj;
    }

    public void setObj(ObjectBean obj) {
        this.obj = obj;
    }
}
