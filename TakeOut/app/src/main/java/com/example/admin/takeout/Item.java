package com.example.admin.takeout;

/**
 * Created by admin on 2017/4/6.
 */

public class Item {
    private String name;
    private int imageId;

    public Item(String name , int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
