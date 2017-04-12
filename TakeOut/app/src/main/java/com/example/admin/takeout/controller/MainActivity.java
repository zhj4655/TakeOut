package com.example.admin.takeout.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.takeout.R;
import com.example.admin.takeout.adapter.StoreAdapter;
import com.example.admin.takeout.data.Data;
import com.example.admin.takeout.entity.StoreInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener{
    Data app;

    TextView home;
    TextView personal;
    TextView order;
    ImageView head_back;
    TextView head_title;
    TextView head_edit;

    private List<StoreInfo> storeList = new ArrayList<StoreInfo>();

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
        app  = (Data)getApplication();

        home.setOnClickListener(this);
        personal.setOnClickListener(this);
        order.setOnClickListener(this);
        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);

        head_title.setText("外卖首页");
        home.setBackgroundColor(getResources().getColor(R.color.menu_item_press));

        initStore();

        initEvent();

    }

    public void initStore() {
//        for(StoreInfo storeInfo : app.store_groups){
//            storeList.add(storeInfo);
//        }
// public StoreInfo(String id, String name, int imageUrl, int waitTime, int qsPrice, int psPrice){
    }

    public void initEvent(){
        StoreAdapter storeAdapter = new StoreAdapter(MainActivity.this, R.layout.item_store, app.store_groups);
        ListView listView = (ListView)findViewById(R.id.store_list);
        listView.setAdapter(storeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StoreInfo store = app.store_groups.get(i);
//                Toast.makeText(MainActivity.this, store.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GoodsActivity.class);
                intent.putExtra("store_id", store.getId());
                startActivity(intent);
            }
        });
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
                boolean isLogin = app.isLogin();
                if(isLogin == false) {
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    intent = new Intent(MainActivity.this, PersonalInfoActivity.class);
                    startActivity(intent);
//                    finish();
                }
                break;
            case R.id.head_back:
                finish();
                break;
            case R.id.head_edit:
//                intent = new Intent(MainActivity.this, GoodsActivity.class);
                break;
            default:
                break;
        }
    }
}
