package com.yys.dao;

import com.yys.entity.ShiShen;

import java.util.ArrayList;

public interface IShiShenDao {
    /**
     * 查询单个式神图标信息
     *
     * @param name 查询式神名
     * @return 信息
     */
    ArrayList<ShiShen> QueryShiShenByName(String name);

    /**
     * 查询所有式神信息
     *
     * @return 所有式神信息
     */
    ArrayList<ShiShen> QueryShiShen();

    /**
     * 添加式神信息
     *
     * @param newData 新数据
     * @return true：成功 false：失败
     */
    boolean AddShiShen(ShiShen newData);

    /**
     * 删除式神信息
     *
     * @param name 需要删除的式神名
     * @return true：成功 false：失败
     */
    boolean DeleteShiShen(String name);

    /**
     * 修改式神信息
     *
     * @param newData 新信息
     * @return true：成功 false：失败
     */
    boolean UpdateShiShen(ShiShen newData);
}
