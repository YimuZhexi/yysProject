package com.yys.service.impl;

import com.yys.entity.ShiShen;
import com.yys.factory.DaoFactory;
import com.yys.service.IShiShenService;

import java.util.ArrayList;

public class ShiShenServiceImpl implements IShiShenService {
    /**
     * 根据名称查询式神
     *
     * @param name 式神名称
     * @return 对应的式神对象
     */
    @Override
    public ShiShen QueryShiShenByName(String name) {
        if (name != null) {
            return DaoFactory.getShiShenDao().QueryShiShenByName(name);
        }
        return null;
    }

    /**
     * 添加式神
     *
     * @param newData 待添加的式神对象
     * @return 添加成功返回true，否则返回false
     */
    @Override
    public boolean AddShiShen(ShiShen newData) {
        // 检查待添加的式神对象是否为空以及式神名称是否为空
        if (newData != null && newData.getShiShenName() != null) {
            // 调用DaoFactory中的ShiShenDao的AddShiShen方法添加式神
            return DaoFactory.getShiShenDao().AddShiShen(newData);
        }
        // 如果式神对象为空或式神名称为空，则返回false
        return false;
    }


    /**
     * 删除式神
     *
     * @param name 式神名称
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean DeleteShiShen(String name) {
        if (name != null) {
            return DaoFactory.getShiShenDao().DeleteShiShen(name);
        }
        return false;
    }

    /**
     * 更新式神
     *
     * @param newData 待更新的式神对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean UpdateShiShen(ShiShen newData) {
        // 检查待更新的式神对象是否为空以及式神名称是否为空
        if (newData != null && newData.getShiShenName() != null) {
            // 调用DaoFactory中的ShiShenDao的UpdateShiShen方法更新式神
            return DaoFactory.getShiShenDao().UpdateShiShen(newData);
        }
        // 如果式神对象为空或者式神名称为空，则更新失败，返回false
        return false;
    }


    /**
     * 查询所有式神
     *
     * @return 所有式神对象的列表
     */
    @Override
    public ArrayList<ShiShen> QueryShiShen() {
        // 调用 ShiShenDao 的 QueryShiShen 方法查询所有式神
        if (DaoFactory.getShiShenDao().QueryShiShen() != null) {
            return DaoFactory.getShiShenDao().QueryShiShen();
        }
        // 如果查询结果为空，则返回 null
        return null;
    }

}
