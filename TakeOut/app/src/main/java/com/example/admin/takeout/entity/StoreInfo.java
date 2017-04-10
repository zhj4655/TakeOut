package com.example.admin.takeout.entity;

/**
 * Created by admin on 2017/4/7.
 */
/**
 * 店铺信息
 */
public class StoreInfo
{
    protected String Id;
    protected String name;
    protected boolean isChoosed;
    private boolean isEdtor;
    private int imageUrl;
    private int waitTime;
    private int qsPrice;
    private int psPrice;

    public StoreInfo(String id, String name) {
        Id = id;
        this.name = name;
    }

    public StoreInfo(String id, String name, int imageUrl, int waitTime, int qsPrice, int psPrice){
        Id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.waitTime = waitTime;
        this.qsPrice = qsPrice;
        this.psPrice = psPrice;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
    public int getImageUrl() {
        return imageUrl;
    }

    public boolean isEdtor() {
        return isEdtor;
    }
//    public boolean getIsEdtor() {
//        return isEdtor;
//    }

    public void setIsEdtor(boolean isEdtor) {
        this.isEdtor = isEdtor;
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
    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getQsPrice() {
        return qsPrice;
    }

    public void setQsPrice(int qsPrice) {
        this.qsPrice = qsPrice;
    }

    public int getPsPrice() {
        return psPrice;
    }

    public void setPsPrice(int psPrice) {
        this.psPrice = psPrice;
    }
}

