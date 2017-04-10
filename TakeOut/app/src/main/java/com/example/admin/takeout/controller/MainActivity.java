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
import com.example.admin.takeout.entity.StoreInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener{

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

        home.setOnClickListener(this);
        personal.setOnClickListener(this);
        order.setOnClickListener(this);
        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);

        head_title.setText("外卖首页");

        initStore();

        initEvent();

    }

    public void initStore() {
        String name[] = {"兰州拉面馆","肯德基", "麦当劳", "烤肉拌饭", "水饺店","兰州拉面馆","肯德基", "麦当劳", "烤肉拌饭", "水饺店"};
        int image[] = {R.drawable.store1,R.drawable.store2,R.drawable.store3,R.drawable.store4,R.drawable.store5,
                R.drawable.store1,R.drawable.store2,R.drawable.store3,R.drawable.store4,R.drawable.store5};
        for(int i = 0; i < 10; i++){
            storeList.add(new StoreInfo(""+i, name[i], image[i], 10 + new Random().nextInt(40),
                    8 + new Random().nextInt(10), new Random().nextInt(3)));
        }
// public StoreInfo(String id, String name, int imageUrl, int waitTime, int qsPrice, int psPrice){
    }

    public void initEvent(){
        StoreAdapter storeAdapter = new StoreAdapter(MainActivity.this, R.layout.item_store, storeList);
        ListView listView = (ListView)findViewById(R.id.store_list);
        listView.setAdapter(storeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StoreInfo store = storeList.get(i);
//                Toast.makeText(MainActivity.this, store.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GoodsActivity.class);
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
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
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
