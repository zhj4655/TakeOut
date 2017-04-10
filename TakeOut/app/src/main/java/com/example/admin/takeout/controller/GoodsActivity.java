package com.example.admin.takeout.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.takeout.R;
import com.example.admin.takeout.adapter.GoodAdapter;
import com.example.admin.takeout.entity.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/10.
 */

public class GoodsActivity extends Activity implements View.OnClickListener{

    List<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
    ImageView head_back;
    TextView head_title;
    TextView head_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shop_detail_layout);

        head_back = (ImageView)findViewById(R.id.head_back);
        head_title = (TextView)findViewById(R.id.head_title);
        head_edit = (TextView)findViewById(R.id.head_edit);

        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);

        head_title.setText("**美食店");

        initGoods();

        initEvent();
    }

    private void initEvent() {
        GoodAdapter goodAdapter = new GoodAdapter(GoodsActivity.this, R.layout.shop_detail_layout, goodsList);
        ListView listView = (ListView)findViewById(R.id.store_item_list);
        listView.setAdapter(goodAdapter);

    }

    private void initGoods() {
        String name[] = {"美食1","美食2","美食3","美食4","美食5"};
        int image[] = {R.drawable.store1,R.drawable.store2,R.drawable.store3,R.drawable.store4,R.drawable.store5};
        for(int i = 0; i < 5; i++){
            //GoodsInfo(String id, String name, int goodsImg, int count, double price)
            goodsList.add(new GoodsInfo(i+"", name[i], image[i], 0, 8.00));
        }
    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
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
