//附近商家
package com.example.lxiao.yummyorder.yummyorder.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lxiao.yummyorder.R;

public class NearShops extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nearshops);
//        TextView tv = (TextView)findViewById(R.id.merchant);
//        TextPaint tp = tv.getPaint();
//        tp.setFakeBoldText(true);
        ImageButton mainPage = (ImageButton) findViewById(R.id.mainpage);
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NearShops.this, Shop1.class);
                startActivity(intent);
            }
        });
        TextView tv1=(TextView)findViewById(R.id.shop1);
        TextView tv2=(TextView)findViewById(R.id.shop2);
        TextView tv3=(TextView)findViewById(R.id.shop3);
        View.OnClickListener handler=new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=null;
                switch (v.getId()) {
                    case R.id.shop1:
                        intent = new Intent(NearShops.this, Shop1.class);
                        break;
                    case R.id.shop2:
                        intent = new Intent(NearShops.this, Shop2.class);
                        break;
                }
                startActivity(intent);
            }
        };
        tv1.setOnClickListener(handler);
        tv2.setOnClickListener(handler);
        tv3.setOnClickListener(handler);
    }


//    public void onClick(View v) {
//        Intent intent = null;
//        switch (v.getId()) {
//            case R.id.shop1:
//                intent = new Intent(NearShops.this, Shop1.class);
//                break;
//            case R.id.shop2:
//                intent = new Intent(NearShops.this, Shop2.class);
//                break;
//        }
//        startActivity(intent);
//    }
}
