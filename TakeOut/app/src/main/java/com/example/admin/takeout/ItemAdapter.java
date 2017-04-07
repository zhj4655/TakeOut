package com.example.admin.takeout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    private int resourceId;
    public ItemAdapter(Context context, int resource, List<Item> object) {
        super(context, resource, object);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        View view;
        ViewHoder viewHoder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHoder = new ViewHoder();
            viewHoder.itemName = (TextView)view.findViewById(R.id.item_name);
            viewHoder.itemImage = (ImageView) view.findViewById(R.id.item_image);
            view.setTag(viewHoder);
        }
        else{
            view = convertView;
            viewHoder = (ViewHoder)view.getTag();
        }
        viewHoder.itemImage.setImageResource(item.getImageId());
        viewHoder.itemName.setText(item.getName());
        return view;

    }
    class ViewHoder{
        ImageView itemImage;
        TextView itemName;
    }
}
