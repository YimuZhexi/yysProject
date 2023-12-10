package com.yys.service.impl;

import com.yys.dao.IShiShenSkillDao;
import com.yys.entity.ShiShenSkill;
import com.yys.factory.DaoFactory;
import com.yys.service.IShiShenSkillService;

public class ShiShenSkillServiceImpl implements IShiShenSkillService {
    IShiShenSkillDao shiShenSkillDao = DaoFactory.getShiShenSkillDao();

    /**
     * 添加式神技能
     *
     * @param shiShenSkill 式神技能对象
     * @return 是否成功添加
     */
    @Override
    public boolean AddShiShenSkill(ShiShenSkill shiShenSkill) {
        // 检查参数是否为空，以及式神名称是否为空
        if (shiShenSkill != null && shiShenSkill.getShiShenName() != null) {
            // 调用式神技能数据访问对象的添加式神技能方法
            return shiShenSkillDao.AddShiShenSkill(shiShenSkill);
        }
        // 如果参数为空或式神名称为空，返回false
        return false;
    }


    /**
     * 更新式神技能
     *
     * @param shiShenSkill 式神技能对象
     * @return 是否成功更新
     */
    @Override
    public boolean UpdateShiShenSkill(ShiShenSkill shiShenSkill) {
        // 检查参数是否有效
        if (shiShenSkill != null && shiShenSkill.getShiShenName() != null) {
            // 调用DaoFactory的getShiShenSkillDao方法获取式神技能Dao对象
            // 调用式神技能Dao对象的UpdateShiShenSkill方法更新式神技能
            return shiShenSkillDao.UpdateShiShenSkill(shiShenSkill);
        }
        // 参数无效，返回false
        return false;
    }


    /**
     * 根据名称删除式神技能
     *
     * @param name 式神技能名称
     * @return 是否成功删除
     */
    @Override
    public boolean DeleteShiShenSkillByName(String name) {
        if (name != null) {
            return shiShenSkillDao.DeleteShiShenSkill(name);
        }
        return false;
    }

    /**
     * 查询式神技能
     *
     * @param name 式神技能名称
     * @return 式神技能对象
     */
    @Override
    public ShiShenSkill QueryShiShenSkill(String name) {
        if (name != null) {
            return shiShenSkillDao.QueryShiShenSkill(name);
        }
        return null;
    }
}
