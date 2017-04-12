package com.example.admin.takeout.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.takeout.R;
import com.example.admin.takeout.data.Data;

/**
 * Created by admin on 2017/4/6.
 */

public class RegistActivity extends Activity implements View.OnClickListener{
    Data app;

    Button login_tag;
    Button reg_tag;
    Button regist;

    TextView home;
    TextView personal;
    TextView order;
    ImageView head_back;
    TextView head_title;
    TextView head_edit;

    EditText account;
    EditText password;
    EditText repassword;
    EditText nickname;
    RadioGroup gender;
    RadioButton man;
    RadioButton woman;

    String act, pwd, rpwd, nick, gend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.regist_layout);
        app = (Data)getApplication();
        login_tag = (Button)findViewById(R.id.login_tag);
        reg_tag = (Button)findViewById(R.id.reg_tag);
        regist = (Button)findViewById(R.id.regist);
        home = (TextView)findViewById(R.id.bottom_home);
        personal = (TextView)findViewById(R.id.bottom_personal);
        order = (TextView)findViewById(R.id.buttom_cart);
        head_back = (ImageView)findViewById(R.id.head_back);
        head_title = (TextView)findViewById(R.id.head_title);
        head_edit = (TextView)findViewById(R.id.head_edit);
        account = (EditText)findViewById(R.id.account);
        password = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.repassword);
        nickname = (EditText)findViewById(R.id.nickname);
        gender = (RadioGroup)findViewById(R.id.reg_gender);
        man = (RadioButton)findViewById(R.id.reg_man);
        woman = (RadioButton)findViewById(R.id.reg_woman);


        login_tag.setOnClickListener(this);
        reg_tag.setOnClickListener(this);
        regist.setOnClickListener(this);
        home.setOnClickListener(this);
        personal.setOnClickListener(this);
        order.setOnClickListener(this);
        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == man.getId()){
                    gend = "男";
                }
                else{
                    gend = "女";
                }
            }
        });


        head_title.setText("注册");
        personal.setBackgroundColor(getResources().getColor(R.color.menu_item_press));
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
                act = account.getText().toString();
                pwd = password.getText().toString();
                rpwd = repassword.getText().toString();
                nick = nickname.getText().toString();
                if(gend == null)
                    gend  = "男";


                if(!pwd.equals(rpwd)){
                    Toast.makeText(RegistActivity.this, "两次密码输入不相同，请重新输入", Toast.LENGTH_SHORT).show();
                    return ;
                }

                app.setUserInfo(act, pwd, nick, gend, "", "");
                Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
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
