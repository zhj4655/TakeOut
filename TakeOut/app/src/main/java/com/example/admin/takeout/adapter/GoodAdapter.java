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
import com.example.admin.takeout.entity.GoodsInfo;

import java.util.List;

/**
 * Created by admin on 2017/4/10.
 */

public class GoodAdapter extends ArrayAdapter<GoodsInfo> {
    private Context context;
    private List<GoodsInfo> goods;
    private int resourceId;

    private ModifyCountInterface modifyCountInterface;

    public GoodAdapter(Context context, int resource, List<GoodsInfo> goods) {
        super(context, resource, goods);
        this.context = context;
        this.goods = goods;
        resourceId = resource;
    }

    public void setModifyCountInterface(ModifyCountInterface modifyCountInterface) {
        this.modifyCountInterface = modifyCountInterface;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        final ViewHoder viewHoder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHoder = new ViewHoder();
            viewHoder.name = (TextView)view.findViewById(R.id.good_name);
            viewHoder.imageUrl = (ImageView) view.findViewById(R.id.goods_list_pic);
            viewHoder.price = (TextView)view.findViewById(R.id.good_price);
            viewHoder.count = (TextView)view.findViewById(R.id.good_num);
            viewHoder.good_increase = (TextView)view.findViewById(R.id.good_add);
            viewHoder.good_decrease = (TextView)view.findViewById(R.id.good_reduce);

            view.setTag(viewHoder);
        }else{
            view = convertView;
            viewHoder = (ViewHoder)view.getTag();
        }
        GoodsInfo goodsInfo = (GoodsInfo)getItem(position);
        if(goodsInfo != null) {
            viewHoder.name.setText(goodsInfo.getName());
            viewHoder.imageUrl.setImageResource(goodsInfo.getGoodsImg());
            viewHoder.price.setText("× ￥ " + goodsInfo.getPrice());
            viewHoder.count.setText("" + goodsInfo.getCount());

            viewHoder.good_increase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modifyCountInterface.doIncrease(position,viewHoder.count);
                }
            });
            viewHoder.good_decrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modifyCountInterface.doDecrease(position, viewHoder.count);
                }
            });
        }else{
            goods.remove(position);
        }

        return view;
    }
    class ViewHoder{
        String Id;
        TextView name;
        ImageView imageUrl;
        TextView price;
        TextView count;
        TextView good_increase;
        TextView good_decrease;

    }


    public interface ModifyCountInterface {
        /**
         * 增加操作
         * @param position 元素位置
         * @param showCountView 用于展示变化后数量的View
         */
        public void doIncrease(int position, View showCountView);

        /**
         * 删减操作
         *
         * @param position 元素位置
         * @param showCountView 用于展示变化后数量的View
         */
        public void doDecrease(int position, View showCountView);

    }
}
