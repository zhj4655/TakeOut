package com.example.admin.takeout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.takeout.entity.StoreInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    TextView home;
    TextView personal;
    TextView order;
    ImageView head_back;
    TextView head_title;
    TextView head_edit;

    private List<StoreInfo> shopList = new ArrayList<StoreInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_layout);

        home = (TextView)findViewById(R.id.bottom_home);
        personal = (TextView)findViewById(R.id.bottom_personal);
        order = (TextView)findViewById(R.id.buttom_cart);
        head_back = (ImageView)findViewById(R.id.head_back);
        head_title = (TextView)findViewById(R.id.head_title);
        head_edit = (TextView)findViewById(R.id.head_edit);

        home.setOnClickListener(this);
        personal.setOnClickListener(this);
        order.setOnClickListener(this);
        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);

        head_title.setText("外卖首页");

        initStore();

    }

    public void initStore() {
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.bottom_home:
                break;
            case R.id.buttom_cart:
                intent = new Intent(MainActivity.this, ShopcartActivity.class);
                startActivity(intent);
                break;
            case R.id.bottom_personal:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
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
