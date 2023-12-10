package com.yys.entity;

/**
 * 式神传记实体类
 */
public class ShiShenZhuanJi {
    private String shiShenName;
    private String zhuanJi1;
    private String zhuanJi2;
    private String zhuanJi3;

    public ShiShenZhuanJi() {
    }

    /**
     * @param shiShenName 式神名
     * @param zhuanJi1    传记1
     * @param zhuanJi2    传记2
     * @param zhuanJi3    传记3
     */
    public ShiShenZhuanJi(String shiShenName, String zhuanJi1, String zhuanJi2, String zhuanJi3) {
        this.shiShenName = shiShenName;
        this.zhuanJi1 = zhuanJi1;
        this.zhuanJi2 = zhuanJi2;
        this.zhuanJi3 = zhuanJi3;
    }

    /**
     * @return 式神名
     */
    public String getShiShenName() {
        return shiShenName;
    }

    /**
     * @param shiShenName 式神名
     */
    public void setShiShenName(String shiShenName) {
        this.shiShenName = shiShenName;
    }

    /**
     * @return 传记1
     */
    public String getZhuanJi1() {
        return zhuanJi1;
    }

    /**
     * @param zhuanJi1 传记1
     */
    public void setZhuanJi1(String zhuanJi1) {
        this.zhuanJi1 = zhuanJi1;
    }

    /**
     * @return 传记2
     */
    public String getZhuanJi2() {
        return zhuanJi2;
    }

    /**
     * @param zhuanJi2 传记2
     */
    public void setZhuanJi2(String zhuanJi2) {
        this.zhuanJi2 = zhuanJi2;
    }

    /**
     * @return 传记3
     */
    public String getZhuanJi3() {
        return zhuanJi3;
    }

    /**
     * @param zhuanJi3 传记3
     */
    public void setZhuanJi3(String zhuanJi3) {
        this.zhuanJi3 = zhuanJi3;
    }
}
