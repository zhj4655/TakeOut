package com.example.admin.takeout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */

public class ShoppingcartActivity extends Activity implements View.OnClickListener{
    private List<Item> itemList = new ArrayList<Item>();

    Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shopcart_layout);

        button_back = (Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);

        initItems();
        ItemAdapter adapter = new ItemAdapter(ShoppingcartActivity.this, R.layout.item_layout, itemList);
//        ListView listView = (ListView)findViewById(R.id.lv_cart_item);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Item item = itemList.get(position);
//                Toast.makeText(ShoppingcartActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }
    private void initItems(){
        Item item_1 = new Item("1", R.drawable.item);
        itemList.add(item_1);
        Item item_2 = new Item("2", R.drawable.item);
        itemList.add(item_2);
        Item item_3 = new Item("3", R.drawable.item);
        itemList.add(item_3);
        Item item_4 = new Item("4", R.drawable.item);
        itemList.add(item_4);
        Item item_5 = new Item("5", R.drawable.item);
        itemList.add(item_5);
        Item item_6 = new Item("6", R.drawable.item);
        itemList.add(item_6);
        Item item_7 = new Item("7", R.drawable.item);
        itemList.add(item_7);
        Item item_8 = new Item("8", R.drawable.item);
        itemList.add(item_8);
        Item item_9 = new Item("9", R.drawable.item);
        itemList.add(item_9);

    }
}
