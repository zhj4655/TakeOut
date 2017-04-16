package com.example.admin.takeout.data;

import android.app.Application;

import com.example.admin.takeout.R;
import com.example.admin.takeout.entity.GoodsInfo;
import com.example.admin.takeout.entity.StoreInfo;
import com.example.admin.takeout.entity.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/11.
 */

public class Data extends Application {
    private boolean isLogin;
    public UserInfo userInfo = new UserInfo();

    public List<StoreInfo> store_groups= new ArrayList<StoreInfo>();
    public Map<String , List<GoodsInfo>> all_goods = new HashMap<String , List<GoodsInfo>>();
    public Map<String , List<GoodsInfo>> cart_goods = new HashMap<String, List<GoodsInfo>>();

    @Override
    public void onCreate() {
        isLogin = false;
        super.onCreate();
        initData();
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setUserInfo(String account, String password, String nickname, String gender, String tel, String address){
        userInfo.setAccount(account);
        userInfo.setPassword(password);
        userInfo.setNickname(nickname);
        userInfo.setGender(gender);
        userInfo.setTel(tel);
        userInfo.setAddress(address);
    }

    private void initData() {
        String name[] = {"兰州拉面馆","肯德基", "麦当劳", "烤肉拌饭", "水饺店"};
        int image[] = {R.drawable.store1,R.drawable.store2,R.drawable.store3,R.drawable.store4,R.drawable.store5};
        int waitTime[] = {30, 32, 50, 15, 5};
        int qsPrice[] = {10, 12, 11, 13, 15};
        int psPrice[] = {1, 2, 1, 0, 1};

        int[][]   foodImg={{R.drawable.food1_1,R.drawable.food1_2,R.drawable.food1_3,R.drawable.food1_4,R.drawable.food1_5},
                {R.drawable.food2_1,R.drawable.food2_2,R.drawable.food2_3,R.drawable.food2_4,R.drawable.food2_5},
                {R.drawable.goods1,R.drawable.goods2,R.drawable.goods3,R.drawable.goods4,R.drawable.goods5},
                {R.drawable.goods1,R.drawable.goods2,R.drawable.goods3,R.drawable.goods4,R.drawable.goods5},
                {R.drawable.goods1,R.drawable.goods2,R.drawable.goods3,R.drawable.goods4,R.drawable.goods5}};

        double goodPrice [][]= {{10.00, 10.00, 7.50, 8.00, 9.00},
                {15.00, 12.00, 10.00, 5.00, 15.00},
                {8.00, 9.00, 10.00, 3.50, 4.00},
                {8.00, 9.00, 10.00, 7.00, 8.50},
                {8.00, 9.00, 10.00, 3.99, 2.00}};
        String goodName[][] = {{"牛肉拉面","牛肉刀削面","西红柿鸡蛋面","三鲜面","炸酱面"},
                {"香辣/劲脆鸡腿堡","培根鸡腿燕麦堡","香辣鸡翅","薯条","红豆圆奶茶"},
                {"美食1","美食2","美食3","美食4","美食5"},
                {"美食1","美食2","美食3","美食4","美食5"},
                {"美食1","美食2","美食3","美食4","美食5"}};

        for(int i = 0; i < 5; i ++){
            store_groups.add(new StoreInfo(i + "",name[i], image[i], waitTime[i], qsPrice[i], psPrice[i]));
            List<GoodsInfo> good = new ArrayList<GoodsInfo>();
            for(int j = 0; j < 5; j++){
                good.add(new GoodsInfo(j + "", goodName[i][j], foodImg[i][j], 0, goodPrice[i][j]));
            }
            all_goods.put(i+"", good);
        }
    }

}
