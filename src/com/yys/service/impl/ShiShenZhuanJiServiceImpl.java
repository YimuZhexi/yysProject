package com.yys.service.impl;

import com.yys.entity.ShiShenZhuanJi;
import com.yys.factory.DaoFactory;
import com.yys.service.IShiShenZhuanJiService;

public class ShiShenZhuanJiServiceImpl implements IShiShenZhuanJiService {
    /**
     * 更新式神传记
     *
     * @param newData 要更新的新数据
     * @return 更新是否成功
     */
    @Override
    public boolean UpdateShiShenZhuanJi(ShiShenZhuanJi newData) {
        if (newData != null && newData.getShiShenName() != null) {
            // 调用DaoFactory实例的getShiShenZhuanJiDao方法获取ShiShenZhuanJiDao对象
            return DaoFactory.getShiShenZhuanJiDao().UpdateShiShenZhuanJi(newData);
        }
        return false;
    }


    /**
     * 根据名称删除式神传记
     *
     * @param name 要删除的式神传记的名称
     * @return 删除是否成功
     */
    @Override
    public boolean DeleteShiShenZhuanJiByName(String name) {
        if (name != null) {
            return DaoFactory.getShiShenZhuanJiDao().DeleteShiShenZhuanJi(name);
        }
        return false;
    }

    /**
     * 查询式神传记
     *
     * @param name 要查询的式神传记的名称
     * @return 查询到的式神传记对象
     */
    @Override
    public ShiShenZhuanJi QueryShiShenZhuanJi(String name) {
        if (name != null) {
            return DaoFactory.getShiShenZhuanJiDao().QueryShiShenZhuanJi(name);
        }
        return null;
    }

    /**
     * 添加式神传记
     *
     * @param newData 要添加的新数据
     * @return 添加是否成功
     */
    @Override
    public boolean AddShiShenZhuanJi(ShiShenZhuanJi newData) {
        if (newData != null && newData.getShiShenName() != null) {
            return DaoFactory.getShiShenZhuanJiDao().AddShiShenZhuanJi(newData);
        }
        return false;
    }
}
