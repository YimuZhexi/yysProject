package com.yys.service;

import com.yys.entity.ShiShenAttribute;

import java.util.ArrayList;

/**
 * 式神详情服务接口
 */
public interface IShiShenAttributeService {
    /**
     * 添加式神属性
     *
     * @param shiShenAttribute 式神属性对象
     * @return 是否成功添加
     */
    public boolean AddShiShenAttribute(ShiShenAttribute shiShenAttribute);

    /**
     * 更新式神属性
     *
     * @param shiShenAttribute 式神属性对象
     * @return 是否成功更新
     */
    public boolean UpdateShiShenAttribute(ShiShenAttribute shiShenAttribute);

    /**
     * 根据式神名字删除式神属性
     *
     * @param name 式神名字
     * @return 是否成功删除
     */
    public boolean DeleteShiShenAttributeByName(String name);

    /**
     * 根据式神名字查询式神属性列表
     *
     * @param name 式神名字
     * @return 式神属性列表
     */
    public ArrayList<ShiShenAttribute> QueryByName(String name);
}

