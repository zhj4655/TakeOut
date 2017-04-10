package com.example.admin.takeout.entity;

/**
 * Created by admin on 2017/4/7.
 */
/**
 * 商品信息
 */
public class GoodsInfo {
    protected String Id;
    protected String name;
    protected boolean isChoosed;
    private String imageUrl;
    private String desc;
    private double price;
    private int count;
    private int position;// 绝对位置，只在ListView构造的购物车中，在删除时有效
    private int goodsImg;


    public int getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(int goodsImg) {
        this.goodsImg = goodsImg;
    }

    public GoodsInfo(String id, String name, int goodsImg, int count, double price){
        Id = id;
        this.name = name;
        this.goodsImg = goodsImg;
        this.count = count;
        this.price = price;
    }

    public GoodsInfo(String id, String name, String desc, double price, int count,int goodsImg) {
        Id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.count = count;
        this.goodsImg=goodsImg;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean isChoosed) {
        this.isChoosed = isChoosed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}

