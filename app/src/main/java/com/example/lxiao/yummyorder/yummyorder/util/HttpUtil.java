package com.example.lxiao.yummyorder.yummyorder.util;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
    public static void sendOkHttpRequest(String address,int type,String reqbody,okhttp3.Callback callback) {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client=new OkHttpClient();
        Request request;
        if(type==0){
           request=new Request.Builder().url(address).build();
        }
        else if(type==1){
            RequestBody body = RequestBody.create(JSON, reqbody);
            request=new Request.Builder().url(address).post(body).build();
        }
        else if(type==2){
            RequestBody body = RequestBody.create(JSON, reqbody);
            request=new Request.Builder().url(address).put(body).build();
        }
        else if(type==3){
            RequestBody body = RequestBody.create(JSON, reqbody);
            request=new Request.Builder().url(address).delete(body).build();
        }
        else{
            System.out.println("Error http request code!");
            return ;
        }
        client.newCall(request).enqueue(callback);
//        return true;
    }
}
