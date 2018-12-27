package com.example.lxiao.yummyorder.yummyorder.util;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    public static void sendOkHttpRequest(String address,int type,String reqbody,okhttp3.Callback callback) {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                ,reqbody);
        OkHttpClient client=new OkHttpClient();
        Request request;
        if(type==0){
           request=new Request.Builder().url(address).build();
        }
        else if(type==1){
//            Log.d("mm","1");
            RequestBody body = RequestBody.create(JSON, reqbody);
            Log.i("reqbody1",body.toString());
//            Log.d("mm","2");
            request=new Request.Builder().url(address).post(body).build();
        }
        else if(type==2){
//            RequestBody body = RequestBody.create(JSON, reqbody);
            request=new Request.Builder().url(address).post(requestBody).build();
//            request=new Request.Builder().url(address).put(body).build();
        }
        else if(type==3){
            RequestBody body = RequestBody.create(JSON, reqbody);
            request=new Request.Builder().url(address).delete(body).build();
        }
        else{
            System.out.println("Error http request code!");
            return ;
        }
//        Log.d("mm","3");

        OkHttpClient okHttpClient  = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
//        okHttpClient.newCall(request).enqueue(callback);   //法一
        client.newCall(request).enqueue(callback);   //法二
//        return true;
    }
}
