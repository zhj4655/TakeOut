package com.example.admin.takeout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by admin on 2017/4/6.
 */

public class RegistActivity extends Activity implements View.OnClickListener{
    Button button_login_tag;
    Button button_reg_tag;
    Button button_regist;
    Button button_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.regist_layout);
        button_login_tag = (Button)findViewById(R.id.login_tag);
        button_reg_tag = (Button)findViewById(R.id.reg_tag);
        button_regist = (Button)findViewById(R.id.regist);
        button_back = (Button)findViewById(R.id.back);

        button_login_tag.setOnClickListener(this);
        button_reg_tag.setOnClickListener(this);
        button_regist.setOnClickListener(this);
        button_back.setOnClickListener(this);
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
                break;
            case R.id.back:
                finish();
            default:
                break;
        }
    }
}
