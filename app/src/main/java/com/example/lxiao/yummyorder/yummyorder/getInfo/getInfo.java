package com.example.lxiao.yummyorder.yummyorder.getInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.lxiao.yummyorder.R;
import com.example.lxiao.yummyorder.yummyorder.controller.MerchantController;
import com.example.lxiao.yummyorder.yummyorder.controller.UserController;
import com.example.lxiao.yummyorder.yummyorder.util.HttpUtil;
import com.example.lxiao.yummyorder.yummyorder.util.Utility;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class getInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getinfo);
        query();
    }
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

    private void updateView(){
        return ;
    }
    private void  query(){
        final int ContentType=1;
        String address;
        String reqbody;
        int RequestType;
        if(ContentType==1){    //创建商店
            address="http://food2.ngrok.xiaomiqiu.cn/Accounts/Stores";
            RequestType=1;   //post
            reqbody= MerchantController.createMerchant();    //new merchant
        }
        else if(ContentType==0){   //创建用户
            address="http://food2.ngrok.xiaomiqiu.cn/Accounts/Signup";
            RequestType=1;   //post
            reqbody= UserController.createUser();   //new user
        }
        HttpUtil.sendOkHttpRequest(address,RequestType,reqbody,new Callback(){
            @Override
            public void onResponse(Call call, Response response) throws IOException{
                String responseText=response.body().string();
                boolean result=false;
//                Log.i("query","2");
                result=Utility.handleResponse(responseText,ContentType);    //不能下断点，会退出
                Log.i("query","3");
//                if(result){
//                    getInfo.this.runOnUiThread(new Runnable(){
//                        @Override
//                        public void run(){
//                            updateView();
//                        }
//                    });
//                }
            }

            @Override
            public void onFailure(Call call,IOException e){  //没网加载失败
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
