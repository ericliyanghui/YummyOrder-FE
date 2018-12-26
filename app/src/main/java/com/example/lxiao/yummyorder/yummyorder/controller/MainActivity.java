//主页
package com.example.lxiao.yummyorder.yummyorder.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lxiao.yummyorder.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button shops=(Button)findViewById(R.id.near_shops);
        shops.setOnClickListener(new View.OnClickListener(){  //匿名类，只能是内部类，用于继承和实现接口（这里是接口），编译时会自动生成带名字的类
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,NearShops.class);
                startActivity(intent);
            }
        });
    }
}
