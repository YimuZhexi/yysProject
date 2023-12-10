package com.yys.factory;

import com.yys.service.*;
import com.yys.service.impl.*;

/**
 * 服务工厂类，用于创建对应的服务实例
 */
public class ServiceFactory {
    /**
     * 获取式神服务实例
     */
    public static IShiShenService getShiShenService() {
        return new ShiShenServiceImpl();
    }

    /**
     * 获取式神传记服务实例
     */
    public static IShiShenZhuanJiService getShiShenZhuanJiService() {
        return new ShiShenZhuanJiServiceImpl();
    }

    /**
     * 获取式神技能服务实例
     */
    public static IShiShenSkillService getShiShenSkillService() {
        return new ShiShenSkillServiceImpl();
    }

    /**
     * 获取式神属性服务实例
     */
    public static IShiShenAttributeService getShiShenAttributeService() {
        return new ShiShenAttributeServiceImpl();
    }

    /**
     * 获取用户账户服务实例
     */
    public static IUserAccountService getUserAccountService() {
        return new UserAccountServiceImpl();
    }
}

