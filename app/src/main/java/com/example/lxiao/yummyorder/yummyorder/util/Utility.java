package com.example.lxiao.yummyorder.yummyorder.util;

import android.text.TextUtils;
import android.util.Log;

import com.example.lxiao.yummyorder.yummyorder.model.bean.CreatemerchantR;
import com.example.lxiao.yummyorder.yummyorder.model.bean.CreateuserR;
import com.example.lxiao.yummyorder.yummyorder.model.bean.Getstores;
import com.google.gson.Gson;

public class Utility {
////    public static boolean handleResponse(String response){
////        if(!TextUtils.isEmpty(response)){
////            try{
////                JSONArray resObject=new JSONArray(response);
////                for(int i=0;i<resObject.length();i++)
////            }
////            catch(JSONException e){
////                    e.printStackTrace();
////            }
////        }
////        return false;
////    };

    public static boolean handleResponse(String response,int ContentType) {
        //获取所有商家信息
        if (!TextUtils.isEmpty(response)) {
//            Log.d("error","handleResponse1");
//            Log.d("error","handleResponse3");
//            System.out.println("All Stores: " + objbean);
            if(ContentType==2){    //商店所有信息
                Getstores getstores = new Gson().fromJson(response, Getstores.class);
                Getstores.ObjectBean objbean = getstores.getObj();   //若网站没搞好，error在这，是有json返回，格式：{"timestamp":1545876886301,"status":404,"error":"Not Found","message":"No message available","path":"/Accounts/Stores"}
            }
            else if(ContentType==0){   //创建用户返回
                CreateuserR cuR=new Gson().fromJson(response,CreateuserR.class);
//                Log.i("CreateuserR",Integer.toString(cmR.getCode()));
            }
            else if(ContentType==1){   //新建商家
                CreatemerchantR cmR=new Gson().fromJson(response,CreatemerchantR.class);
            }
            Log.i("response",response);
//            Log.i("CreatemerchantR",Integer.toString(cmR.getCode()));
//            Log.i("CreatemerchantR",cmR.getMessage());
            return true;
        }
        Log.d("error","handleResponse2");
        return false;
    }
}
