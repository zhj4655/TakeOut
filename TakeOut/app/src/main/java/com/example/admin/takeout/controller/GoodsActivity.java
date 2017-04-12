package com.example.admin.takeout.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.takeout.R;
import com.example.admin.takeout.adapter.GoodAdapter;
import com.example.admin.takeout.data.Data;
import com.example.admin.takeout.entity.GoodsInfo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/10.
 */

public class GoodsActivity extends Activity implements View.OnClickListener,GoodAdapter.ModifyCountInterface{
    Data app;

    List<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
    ImageView head_back;
    TextView head_title;
    TextView head_edit;
    ListView listView;
    TextView total_price;
    TextView ps_price;
    TextView addShopcart;


    String storeName, storeId;

    private GoodAdapter goodAdapter;
    private double totalPrice = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shop_detail_layout);

//        Log.d("111111111111111","11111111111111111111111");

        Intent intent = getIntent();
        storeId = intent.getStringExtra("store_id");//store可能没传进来
//        Log.d("GoodsActivity", store);//NullPointerException: println needs a message

        app = (Data)getApplication();

        head_back = (ImageView)findViewById(R.id.head_back);
        head_title = (TextView)findViewById(R.id.head_title);
        head_edit = (TextView)findViewById(R.id.head_edit);
        listView = (ListView)findViewById(R.id.store_item_list);
        total_price = (TextView)findViewById(R.id.instore_total_price);
        ps_price = (TextView)findViewById(R.id.instore_ps_price);
        addShopcart = (TextView)findViewById(R.id.add_to_shopcart);

        head_back.setOnClickListener(this);
        head_edit.setOnClickListener(this);
        addShopcart.setOnClickListener(this);

        storeName = app.store_groups.get(Integer.parseInt(storeId)).getName();
        head_title.setText(storeName);

        initGoods();

        initEvent();
    }

    private void initEvent() {
        goodAdapter = new GoodAdapter(GoodsActivity.this, R.layout.shop_item_layout, goodsList);
        goodAdapter.setModifyCountInterface(this);

        listView.setAdapter(goodAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                GoodsInfo good = goodsList.get(i);
////                Toast.makeText(GoodsActivity.this, good.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void initGoods() {
        goodsList = app.all_goods.get(storeId);
        calculate();
//        for(int i = 0; i < app.all_goods.; i++){
//            //GoodsInfo(String id, String name, int goodsImg, int count, double price)
//            goodsList.add(new GoodsInfo(i+"", name[i], image[i], 0, price[i]));
//        }
    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.head_back:
                finish();
                break;
            case R.id.head_edit:
                break;
            case R.id.add_to_shopcart:
                //add_data_to_shopcart
                add_good_to_shopcart();
                Toast.makeText(GoodsActivity.this, "已经添加到订单",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void doIncrease(int position, View showCountView) {
        GoodsInfo goodsInfo = goodsList.get(position);
        int currentCount = goodsInfo.getCount();
        currentCount++;
        goodsInfo.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        goodAdapter.notifyDataSetChanged();

        calculate();

    }

    @Override
    public void doDecrease(int position, View showCountView) {
        GoodsInfo goodsInfo = goodsList.get(position);
        int currentCount = goodsInfo.getCount();
        currentCount--;
        if(currentCount < 0)
            return;
        goodsInfo.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        goodAdapter.notifyDataSetChanged();

        calculate();
    }
    private void calculate() {
        totalPrice = 0.00;
        for(int i = 0; i < goodsList.size(); i++){
            GoodsInfo good = goodsList.get(i);
            totalPrice += good.getPrice() * good.getCount();
        }
        if(totalPrice > 0)
            totalPrice += app.store_groups.get(Integer.parseInt(storeId)).getPsPrice();
        total_price.setText(" ￥ " + totalPrice);
        ps_price.setText(" ￥ " + app.store_groups.get(Integer.parseInt(storeId)).getPsPrice());
    }

    private void add_good_to_shopcart() {
        List<GoodsInfo> add_to_cart = new ArrayList<GoodsInfo>();
        for(int i = 0; i < goodsList.size(); i ++){
            GoodsInfo good = goodsList.get(i);
            if(good.getCount() > 0)
                add_to_cart.add(good);
        }
        app.cart_goods.put(storeId, add_to_cart);
    }
}
