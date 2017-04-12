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
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.takeout.R;
import com.example.admin.takeout.data.Data;

/**
 * Created by admin on 2017/4/11.
 */

public class PersonalInfoActivity extends Activity implements View.OnClickListener{
    Data app;

    Button logout;
    TextView home;
    TextView personal;
    TextView order;
    ImageView head_back;
    TextView head_title;
    TextView head_edit;
    TextView nickname;
    TextView gender;
    TextView tel;
    TextView address;

    Button modify;
    EditText modify_nickname;
    RadioGroup modify_gender;
    RadioButton man;
    RadioButton woman;
    EditText modify_tel;
    EditText modify_address;
    TableLayout info_show;
    TableLayout info_modify;

    String nick, gend, tele, add;

    private boolean islogin;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.personal_info_layout);

        app = (Data)getApplication();
        logout = (Button)findViewById(R.id.logout);
        home = (TextView)findViewById(R.id.bottom_home);
        personal = (TextView)findViewById(R.id.bottom_personal);
        order = (TextView)findViewById(R.id.buttom_cart);
        head_back = (ImageView)findViewById(R.id.head_back);
        head_title = (TextView)findViewById(R.id.head_title);
        head_edit = (TextView)findViewById(R.id.head_edit);
        nickname = (TextView)findViewById(R.id.info_nickname);
        gender = (TextView)findViewById(R.id.info_gender);
        tel = (TextView)findViewById(R.id.info_tel);
        address = (TextView)findViewById(R.id.info_address);

        modify = (Button)findViewById(R.id.modify);
        modify_nickname = (EditText)findViewById(R.id.modify_nickname);
        modify_gender = (RadioGroup)findViewById(R.id.modify_gender);
        man = (RadioButton)findViewById(R.id.modify_man);
        woman = (RadioButton)findViewById(R.id.modify_woman);
        modify_tel = (EditText)findViewById(R.id.modify_tel);
        modify_address = (EditText)findViewById(R.id.modify_address);

        info_show = (TableLayout)findViewById(R.id.info_show);
        info_modify = (TableLayout)findViewById(R.id.info_modify);

        logout.setOnClickListener(this);
        home.setOnClickListener(this);
        personal.setOnClickListener(this);
        order.setOnClickListener(this);
        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);
        modify.setOnClickListener(this);

        setInfo();



        modify_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
    }

    private void setInfo() {
        head_title.setText("个人信息");
        personal.setBackgroundColor(getResources().getColor(R.color.menu_item_press));
        nickname.setText(app.userInfo.getNickname());
        gender.setText(app.userInfo.getGender());
        tel.setText(app.userInfo.getTel());
        address.setText(app.userInfo.getAddress());
    }
    private void setEditInfo() {
        modify_nickname.setText(app.userInfo.getNickname());
        modify_tel.setText(app.userInfo.getTel());
        modify_address.setText(app.userInfo.getAddress());
        if(app.userInfo.getGender().equals("男")){
            man.setChecked(true);
            woman.setChecked(false);
        }else{
            man.setChecked(false);
            woman.setChecked(true);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.logout:
                app.setLogin(false);
                intent = new Intent(PersonalInfoActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bottom_home:
                intent = new Intent(PersonalInfoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttom_cart:
                intent = new Intent(PersonalInfoActivity.this, ShopcartActivity.class);
                startActivity(intent);
                break;
            case R.id.bottom_personal:
                break;
            case R.id.head_back:
                finish();
                break;
            case R.id.head_edit:
                if(flag == 1){
                    info_show.setVisibility(View.VISIBLE);
                    info_modify.setVisibility(View.GONE);
                    head_edit.setText("编辑");
                    setInfo();
                }else{
                    info_show.setVisibility(View.GONE);
                    info_modify.setVisibility(View.VISIBLE);
                    head_edit.setText("完成");
                    setEditInfo();
                }
                flag = (flag + 1) % 2;
                break;
            case R.id.modify:
                nick = modify_nickname.getText().toString();
                tele = modify_tel.getText().toString();
                add = modify_address.getText().toString();
                if(gend == null)
                    gend  = "男";
                app.setUserInfo(app.userInfo.getAccount(), app.userInfo.getPassword(), nick, gend, tele, add);
                Toast.makeText(PersonalInfoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


}
