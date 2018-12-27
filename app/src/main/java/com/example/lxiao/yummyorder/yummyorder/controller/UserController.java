package com.example.lxiao.yummyorder.yummyorder.controller;

import android.util.Log;

import com.example.lxiao.yummyorder.yummyorder.model.bean.CreatemerchantP;
import com.example.lxiao.yummyorder.yummyorder.model.bean.CreateuserP;
import com.google.gson.Gson;

public class UserController {
    public static String createUser() {
        String username="James";
        String password="abcd";
        CreateuserP cu=new CreateuserP();
        cu.setUsername(username);
        cu.setPassword(password);
        Gson gson=new Gson();
        String reqbody=gson.toJson(cu);
        Log.i("reqbody",reqbody);
        return reqbody;
    }
}
