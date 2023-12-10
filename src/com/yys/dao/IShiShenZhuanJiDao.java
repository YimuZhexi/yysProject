package com.yys.dao;

import com.yys.entity.ShiShenZhuanJi;

public interface IShiShenZhuanJiDao {
    /**
     * 查询式神传记
     * @param name 式神名称
     * @return 式神传记
     */
    ShiShenZhuanJi QueryShiShenZhuanJi(String name);

    /**
     * 插入式神传记
     * @param shiShenZhuanJi 要插入的式神传记对象
     * @return 插入成功返回true，否则返回false
     */
    boolean InsertShiShenZhuanJi(ShiShenZhuanJi shiShenZhuanJi);

    /**
     * 更新式神传记
     * @param shiShenZhuanJi 要更新的式神传记对象
     * @return 更新成功返回true，否则返回false
     */
    boolean UpdateShiShenZhuanJi(ShiShenZhuanJi shiShenZhuanJi);

    /**
     * 删除式神传记
     * @param name 要删除的式神名称
     * @return 删除成功返回true，否则返回false
     */
    boolean DeleteShiShenZhuanJi(String name);

}
