package com.yys.dao;

import com.yys.entity.ShiShenSkill;

public interface IShiShenSkillDao {
    /**
     * 查询技能
     * @param name 式神名称
     * @return 技能
     */
    ShiShenSkill QueryShiShenSkill(String name);

    /**
     * 添加技能
     * @param shiShenSkill 技能
     * @return 是否成功
     */
    boolean InsertShiShenSkill(ShiShenSkill shiShenSkill);

    /**
     * 修改技能
     * @param shiShenSkill 技能
     * @return 是否成功
     */
    boolean UpdateShiShenSkill(ShiShenSkill shiShenSkill);

    /**
     * 删除技能
     * @param name 式神名称
     * @return 是否成功
     */
    boolean DeleteShiShenSkill(String name);
}
