package com.example.lxiao.yummyorder.yummyorder.controller;

import android.util.Log;

import com.example.lxiao.yummyorder.yummyorder.model.bean.CreatemerchantP;
import com.google.gson.Gson;

public class MerchantController {
    public static String createMerchant() {
        String name="KFC";
        String phone="123456789";
        String type="Chinese food";
        int user_id=5;   //James
        String address="Wall Street";
        double longitude=123.123;
        double latitude=231.231;
        CreatemerchantP cm=new CreatemerchantP();
        cm.setName(name);
        cm.setPhone(phone);
        cm.setType(type);
        cm.setUser_id(user_id);
        cm.setAddress(address);
        cm.setLongitude(longitude);
        cm.setLatitude(latitude);
        Gson gson=new Gson();
        String reqbody=gson.toJson(cm);
        Log.i("reqbody",reqbody);
        return reqbody;
    }


}
