package com.yys.service;

import com.yys.entity.ShiShen;

import java.util.ArrayList;

/**
 * 式神服务接口
 */
public interface IShiShenService {
    /**
     * 根据名称查询式神
     *
     * @param name 式神名称
     * @return 对应的式神对象
     */
    public ShiShen QueryShiShenByName(String name);

    /**
     * 添加式神
     *
     * @param newData 待添加的式神对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean AddShiShen(ShiShen newData);

    /**
     * 删除式神
     *
     * @param name 式神名称
     * @return 删除成功返回true，否则返回false
     */
    public boolean DeleteShiShen(String name);

    /**
     * 更新式神
     *
     * @param newData 待更新的式神对象
     * @return 更新成功返回true，否则返回false
     */
    public boolean UpdateShiShen(ShiShen newData);

    /**
     * 查询所有式神
     *
     * @return 所有式神对象的列表
     */
    public ArrayList<ShiShen> QueryShiShen();
}

