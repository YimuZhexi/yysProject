package com.yys.factory;

import com.yys.dao.*;
import com.yys.dao.impl.*;

/**
 * 数据访问对象工厂类，用于创建各个数据访问对象的实例
 */
public class DaoFactory {

    /**
     * 返回一个 {@link IShiShenDao} 对象，用于访问神祇数据
     *
     * @return 一个 {@link IShiShenDao} 对象
     */
    public static IShiShenDao getShiShenDao() {
        return new ShiShenDaoImpl();
    }

    /**
     * 返回一个 {@link IShiShenAttributeDao} 对象，用于访问神祇属性数据
     *
     * @return 一个 {@link IShiShenAttributeDao} 对象
     */
    public static IShiShenAttributeDao getShiShenAttributeDao() {
        return new ShiShenAttributeDaoImpl();
    }

    /**
     * 返回一个 {@link IShiShenZhuanJiDao} 对象，用于访问神祇转职数据
     *
     * @return 一个 {@link IShiShenZhuanJiDao} 对象
     */
    public static IShiShenZhuanJiDao getShiShenZhuanJiDao() {
        return new ShiShenZhuanJiDaoImpl();
    }

    /**
     * 返回一个 {@link IShiShenSkillDao} 对象，用于访问神祇技能数据
     *
     * @return 一个 {@link IShiShenSkillDao} 对象
     */
    public static IShiShenSkillDao getShiShenSkillDao() {
        return new ShiShenSkillDaoImpl();
    }

    /**
     * 返回一个 {@link IUserAccountDao} 对象，用于访问用户账户数据
     *
     * @return 一个 {@link IUserAccountDao} 对象
     */
    public static IUserAccountDao getUserAccountDao() {
        return new UserAccountDaoImpl();
    }
}

