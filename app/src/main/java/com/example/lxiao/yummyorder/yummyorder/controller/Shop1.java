//店家1
package com.example.lxiao.yummyorder.yummyorder.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lxiao.yummyorder.R;

public class Shop1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop1);
        TextView s1=(TextView)findViewById(R.id.ms_merchant1);
        TextView s2=(TextView)findViewById(R.id.ms_merchant2);
        TextView s3=(TextView)findViewById(R.id.ms_merchant3);
        View.OnClickListener handler1=new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=null;
                switch (v.getId()) {
                    case R.id.ms_merchant1:
                        intent = new Intent(Shop1.this, Commodity11.class);
                        break;
                    case R.id.ms_merchant2:
                        intent = new Intent(Shop1.this, Commodity12.class);
                        break;
                }
                startActivity(intent);
            }
        };
        s1.setOnClickListener(handler1);
        s2.setOnClickListener(handler1);

    }

}
