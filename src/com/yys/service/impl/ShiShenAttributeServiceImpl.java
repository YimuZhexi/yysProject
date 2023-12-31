package com.yys.service.impl;

import com.yys.dao.IShiShenAttributeDao;
import com.yys.entity.ShiShenAttribute;
import com.yys.factory.DaoFactory;
import com.yys.service.IShiShenAttributeService;

import java.util.ArrayList;

/**
 * 式神属性业务逻辑实现类
 */
public class ShiShenAttributeServiceImpl implements IShiShenAttributeService {
    IShiShenAttributeDao shiShenAttributeDao = DaoFactory.getShiShenAttributeDao();

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
            return shiShenAttributeDao.AddShiShenAttribute(shiShenAttribute);
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
            return shiShenAttributeDao.UpdateShiShenAttribute(shiShenAttribute);
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
            return shiShenAttributeDao.DeleteShiShenAttributeByName(name);
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
            return shiShenAttributeDao.QueryByName(name);
        return null;
    }
}
