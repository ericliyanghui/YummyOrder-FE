package com.example.lxiao.yummyorder.yummyorder.getInfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.lxiao.yummyorder.yummyorder.gson.GetStores;
import com.example.lxiao.yummyorder.yummyorder.util.HttpUtil;
import com.example.lxiao.yummyorder.yummyorder.util.Utility;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@SuppressLint("Registered")
public class getInfo extends AppCompatActivity {
/*    public static boolean handleResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray resObject=new JSONArray(response);
                for(int i=0;i<resObject.length();i++){
                    //GET获取某个评论
                    JSONObject commentObject=resObject.getJSONObject(i);
                }
            }
            catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    };*/
    public static boolean handleResponse(String response){
        //获取所有商家信息
        GetStores getstores=new Gson().fromJson(response,GetStores.class);
        GetStores.ObjectBean objbean=getstores.getObj();
        System.out.println("All Stores: "+objbean);
//        return objbean;
        return true;
    }
    private void updateView(){
        return ;
    }
    private void  query(){
        String address="http://food.ngrok.xiaomiqiu.cn/dishes/store/1";
        String reqbody="reqbody";
        int type=1;
        HttpUtil.sendOkHttpRequest(address,type,reqbody,new Callback(){
            @Override
            public void onResponse(Call call, Response response) throws IOException{
                String responseText=response.body().string();
                boolean result=false;
                result=handleResponse(responseText);
                if(result){
                    getInfo.this.runOnUiThread(new Runnable(){
                        @Override
                        public void run(){
                            updateView();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call call,IOException e){
                getInfo.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getInfo.this,"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
