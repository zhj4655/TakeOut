package com.example.admin.takeout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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

    public StoreAdapter(Context context, int resource, List<StoreInfo> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StoreInfo storeInfo = getItem(position);
        View view;
        ViewHoder viewHoder;
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
        viewHoder.name.setText("兰州拉面馆");
        viewHoder.imageUrl.setImageResource(R.drawable.store1);
        viewHoder.waitTime.setText("配送时间：45分钟");
        viewHoder.qsPrice.setText("起送 ￥ 12.00");
        viewHoder.psPrice.setText("配送 ￥ 1.00");

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
