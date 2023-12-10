package com.yys.dao;

import com.yys.entity.ShiShenAttribute;

import java.util.ArrayList;

public interface IShiShenAttributeDao {
    /**
     * 获取式神详情（包含觉醒前和觉醒后）
     *
     * @param name 式神名
     * @return 两个状态的信息
     */
    ArrayList<ShiShenAttribute> QueryByName(String name);

    /**
     * 添加式神信息
     *
     * @param shiShenAttribute 新的式神信息
     * @return true：成功
     * false：失败
     */
    boolean AddShiShenAttribute(ShiShenAttribute shiShenAttribute);

    /**
     * 修改式神信息
     *
     * @param shiShenAttribute 修改后的信息
     * @return true：成功
     * false：失败
     */
    boolean UpdateShiShenAttribute(ShiShenAttribute shiShenAttribute);

    /**
     * 删除式神信息
     *
     * @param name 需要删除的式神名
     * @return true：成功
     * false：失败
     */
    boolean DeleteShiShenAttributeByName(String name);
}
