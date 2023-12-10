package com.yys.service.impl;

import com.yys.entity.ShiShenAttribute;
import com.yys.factory.DaoFactory;
import com.yys.service.IShiShenAttributeService;

import java.util.ArrayList;

public class ShiShenAttributeServiceImpl implements IShiShenAttributeService {
    /**
     * 添加式神属性
     *
     * @param shiShenAttribute 式神属性对象
     * @return 是否成功添加
     */
    @Override
    public boolean AddShiShenAttribute(ShiShenAttribute shiShenAttribute) {
        // 检查传入参数是否有效
        if (shiShenAttribute != null && shiShenAttribute.getShiShenName() != null)
            // 调用Dao工厂的方法添加式神属性
            return DaoFactory.getShiShenAttributeDao().AddShiShenAttribute(shiShenAttribute);
        // 如果传入参数无效，则返回false
        return false;
    }


    /**
     * 更新式神属性
     *
     * @param shiShenAttribute 式神属性对象
     * @return 是否成功更新
     */
    @Override
    public boolean UpdateShiShenAttribute(ShiShenAttribute shiShenAttribute) {
        // 检查参数是否为空以及式神名称是否为空
        if (shiShenAttribute != null && shiShenAttribute.getShiShenName() != null)
            // 调用DaoFactory实例的getShiShenAttributeDao()方法获取ShiShenAttributeDao对象，并调用其UpdateShiShenAttribute方法更新式神属性
            return DaoFactory.getShiShenAttributeDao().UpdateShiShenAttribute(shiShenAttribute);
        // 参数为空或式神名称为空，返回false
        return false;
    }


    /**
     * 根据式神名字删除式神属性
     *
     * @param name 式神名字
     * @return 是否成功删除
     */
    @Override
    public boolean DeleteShiShenAttributeByName(String name) {
        if (name != null)
            return DaoFactory.getShiShenAttributeDao().DeleteShiShenAttributeByName(name);
        return false;
    }

    /**
     * 根据式神名字查询式神属性列表
     *
     * @param name 式神名字
     * @return 式神属性列表
     */
    @Override
    public ArrayList<ShiShenAttribute> QueryByName(String name) {
        if (name != null)
            return DaoFactory.getShiShenAttributeDao().QueryByName(name);
        return null;
    }
}
