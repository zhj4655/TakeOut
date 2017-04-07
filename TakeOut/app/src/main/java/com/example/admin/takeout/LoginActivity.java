package com.example.admin.takeout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by admin on 2017/4/5.
 */

public class LoginActivity extends Activity implements View.OnClickListener{
    Button button_login_tag;
    Button button_reg_tag;
    Button button_login;
    Button button_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_layout);
        button_login_tag = (Button)findViewById(R.id.login_tag);
        button_reg_tag = (Button)findViewById(R.id.reg_tag);
        button_login = (Button)findViewById(R.id.login);
        button_back = (Button)findViewById(R.id.back);

        button_login_tag.setOnClickListener(this);
        button_reg_tag.setOnClickListener(this);
        button_login.setOnClickListener(this);
        button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.login_tag:
                break;
            case R.id.reg_tag:
                intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.login:
                break;
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }
}
