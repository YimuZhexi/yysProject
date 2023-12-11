package com.yys.entity;

/**
 * 式神实体类
 */
public class ShiShen {
    private String shiShenName;
    private String jueXingQianIcon;
    private String jueXingHouIcon;

    public ShiShen() {
    }

    /**
     * @param shiShenName     式神名
     * @param jueXingQianIcon 式神觉醒前图标
     * @param jueXingHouIcon  式神觉醒后图标
     */
    public ShiShen(String shiShenName, String jueXingQianIcon, String jueXingHouIcon) {
        this.shiShenName = shiShenName;
        this.jueXingQianIcon = jueXingQianIcon;
        this.jueXingHouIcon = jueXingHouIcon;
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
     * @return 式神觉醒前图标
     */
    public String getJueXingQianIcon() {
        return jueXingQianIcon;
    }

    /**
     * @param jueXingQianIcon 式神觉醒前图标
     */
    public void setJueXingQianIcon(String jueXingQianIcon) {
        this.jueXingQianIcon = jueXingQianIcon;
    }

    /**
     * @return 式神觉醒后图标
     */
    public String getJueXingHouIcon() {
        return jueXingHouIcon;
    }

    /**
     * @param jueXingHouIcon 式神觉醒后图标
     */
    public void setJueXingHouIcon(String jueXingHouIcon) {
        this.jueXingHouIcon = jueXingHouIcon;
    }
}
