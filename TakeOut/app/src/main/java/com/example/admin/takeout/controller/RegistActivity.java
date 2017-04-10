package com.example.admin.takeout.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.takeout.R;

/**
 * Created by admin on 2017/4/6.
 */

public class RegistActivity extends Activity implements View.OnClickListener{

    Button login_tag;
    Button reg_tag;
    Button regist;

    TextView home;
    TextView personal;
    TextView order;
    ImageView head_back;
    TextView head_title;
    TextView head_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.regist_layout);
        login_tag = (Button)findViewById(R.id.login_tag);
        reg_tag = (Button)findViewById(R.id.reg_tag);
        regist = (Button)findViewById(R.id.regist);
        home = (TextView)findViewById(R.id.bottom_home);
        personal = (TextView)findViewById(R.id.bottom_personal);
        order = (TextView)findViewById(R.id.buttom_cart);
        head_back = (ImageView)findViewById(R.id.head_back);
        head_title = (TextView)findViewById(R.id.head_title);
        head_edit = (TextView)findViewById(R.id.head_edit);

        login_tag.setOnClickListener(this);
        reg_tag.setOnClickListener(this);
        regist.setOnClickListener(this);
        home.setOnClickListener(this);
        personal.setOnClickListener(this);
        order.setOnClickListener(this);
        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);

        head_title.setText("注册");
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.reg_tag:
                break;
            case R.id.login_tag:
                intent = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.regist:
                //注册操作
                break;
            case R.id.bottom_home:
                intent = new Intent(RegistActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttom_cart:
                intent = new Intent(RegistActivity.this, ShopcartActivity.class);
                startActivity(intent);
                break;
            case R.id.bottom_personal:
                break;
            case R.id.head_back:
                finish();
                break;
            case R.id.head_edit:
                break;
            default:
                break;
        }
    }
}
