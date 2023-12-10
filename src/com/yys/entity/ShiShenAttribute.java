package com.yys.entity;

/**
 * 式神属性实体类
 */
public class ShiShenAttribute {
    private String shiShenName;
    private String zhuangTai;
    private int gongJi;
    private int shengMing;
    private int fangYu;
    private int suDu;
    private float baoJi;
    private float baoJiShangHai;
    private float xiaoGuoMingZhong;
    private float xiaoGuoDiKang;
    private byte[] image;

    public ShiShenAttribute() {
    }

    public ShiShenAttribute(String shiShenName, String zhuangTai, int gongJi, int shengMing, int fangYu, int suDu, float baoJi, float baoJiShangHai, float xiaoGuoMingZhong, float xiaoGuoDiKang, byte[] image) {
        this.shiShenName = shiShenName;
        this.zhuangTai = zhuangTai;
        this.gongJi = gongJi;
        this.shengMing = shengMing;
        this.fangYu = fangYu;
        this.suDu = suDu;
        this.baoJi = baoJi;
        this.baoJiShangHai = baoJiShangHai;
        this.xiaoGuoMingZhong = xiaoGuoMingZhong;
        this.xiaoGuoDiKang = xiaoGuoDiKang;
        this.image = image;
    }

    public String getShiShenName() {
        return shiShenName;
    }

    public void setShiShenName(String shiShenName) {
        this.shiShenName = shiShenName;
    }

    public String getZhuangTai() {
        return zhuangTai;
    }

    public void setZhuangTai(String zhuangTai) {
        this.zhuangTai = zhuangTai;
    }

    public int getGongJi() {
        return gongJi;
    }

    public void setGongJi(int gongJi) {
        this.gongJi = gongJi;
    }

    public int getShengMing() {
        return shengMing;
    }

    public void setShengMing(int shengMing) {
        this.shengMing = shengMing;
    }

    public int getFangYu() {
        return fangYu;
    }

    public void setFangYu(int fangYu) {
        this.fangYu = fangYu;
    }

    public int getSuDu() {
        return suDu;
    }

    public void setSuDu(int suDu) {
        this.suDu = suDu;
    }

    public float getBaoJi() {
        return baoJi;
    }

    public void setBaoJi(float baoJi) {
        this.baoJi = baoJi;
    }

    public float getBaoJiShangHai() {
        return baoJiShangHai;
    }

    public void setBaoJiShangHai(float baoJiShangHai) {
        this.baoJiShangHai = baoJiShangHai;
    }

    public float getXiaoGuoMingZhong() {
        return xiaoGuoMingZhong;
    }

    public void setXiaoGuoMingZhong(float xiaoGuoMingZhong) {
        this.xiaoGuoMingZhong = xiaoGuoMingZhong;
    }

    public float getXiaoGuoDiKang() {
        return xiaoGuoDiKang;
    }

    public void setXiaoGuoDiKang(float xiaoGuoDiKang) {
        this.xiaoGuoDiKang = xiaoGuoDiKang;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
