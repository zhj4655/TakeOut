package com.example.admin.takeout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.admin.takeout.R;
import com.example.admin.takeout.entity.StoreInfo;

import java.util.List;

/**
 * Created by admin on 2017/4/8.
 */

public class StoreAdapter extends ArrayAdapter<StoreInfo> {

    private int resourceId;
    private List<StoreInfo> stores;
    private Context context;

    public StoreAdapter(Context context, int resource, List<StoreInfo> stores) {
        super(context, resource, stores);
        resourceId = resource;
        this.stores = stores;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        final ViewHoder viewHoder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHoder = new ViewHoder();
            viewHoder.name = (TextView)view.findViewById(R.id.store_name);
            viewHoder.imageUrl = (ImageView) view.findViewById(R.id.store_image);
            viewHoder.waitTime = (TextView)view.findViewById(R.id.wait_time);
            viewHoder.qsPrice = (TextView)view.findViewById(R.id.qs_price);
            viewHoder.psPrice = (TextView)view.findViewById(R.id.ps_price);

            view.setTag(viewHoder);
        }
        else{
            view = convertView;
            viewHoder = (ViewHoder)view.getTag();
        }
        StoreInfo storeInfo = (StoreInfo)getItem(position);
        if(storeInfo != null) {
            viewHoder.name.setText(storeInfo.getName());
            viewHoder.imageUrl.setImageResource(storeInfo.getImageUrl());
            viewHoder.waitTime.setText("配送时间："+storeInfo.getWaitTime()+"分钟");
            viewHoder.qsPrice.setText("起送费 ￥ "+storeInfo.getQsPrice());
            viewHoder.psPrice.setText("配送费 ￥ "+storeInfo.getPsPrice());
        }else{
            stores.remove(position);
        }

        return view;
    }
    class ViewHoder{
        String Id;
        TextView name;
        ImageView imageUrl;
        TextView waitTime;
        TextView qsPrice;
        TextView psPrice;
    }
}
