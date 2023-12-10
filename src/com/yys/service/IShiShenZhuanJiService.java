package com.yys.service;

import com.yys.entity.ShiShenZhuanJi;

/**
 * 式神传记服务接口
 */
public interface IShiShenZhuanJiService {
    /**
     * 更新式神传记
     *
     * @param newData 要更新的新数据
     * @return 更新是否成功
     */
    public boolean UpdateShiShenZhuanJi(ShiShenZhuanJi newData);

    /**
     * 根据名称删除式神传记
     *
     * @param name 要删除的式神传记的名称
     * @return 删除是否成功
     */
    public boolean DeleteShiShenZhuanJiByName(String name);

    /**
     * 查询式神传记
     *
     * @param name 要查询的式神传记的名称
     * @return 查询到的式神传记对象
     */
    public ShiShenZhuanJi QueryShiShenZhuanJi(String name);

    /**
     * 添加式神传记
     *
     * @param newData 要添加的新数据
     * @return 添加是否成功
     */
    public boolean AddShiShenZhuanJi(ShiShenZhuanJi newData);
}

