package com.yys.service;

import com.yys.entity.ShiShenSkill;

/**
 * 式神技能服务接口
 */
public interface IShiShenSkillService {
    /**
     * 添加式神技能
     *
     * @param shiShenSkill 式神技能对象
     * @return 是否成功添加
     */
    public boolean AddShiShenSkill(ShiShenSkill shiShenSkill);

    /**
     * 更新式神技能
     *
     * @param shiShenSkill 式神技能对象
     * @return 是否成功更新
     */
    public boolean UpdateShiShenSkill(ShiShenSkill shiShenSkill);

    /**
     * 根据名称删除式神技能
     *
     * @param name 式神技能名称
     * @return 是否成功删除
     */
    public boolean DeleteShiShenSkillByName(String name);

    /**
     * 查询式神技能
     *
     * @param name 式神技能名称
     * @return 式神技能对象
     */
    public ShiShenSkill QueryShiShenSkill(String name);
}

