package com.yys.entity;

public class ShiShenSkill {
    private String shiShenName;
    private String skill1;
    private String skillIcon1;
    private String skillDescription1;
    private String skill2;
    private String skillIcon2;
    private String skillDescription2;
    private String skill3;
    private String skillIcon3;
    private String skillDescription3;

    public ShiShenSkill() {
    }

    public ShiShenSkill(String shiShenName, String skill1, String skillIcon1, String skillDescription1, String skill2, String skillIcon12, String skillDescription2, String skill3, String skillIcon13, String skillDescription3) {
        this.shiShenName = shiShenName;
        this.skill1 = skill1;
        this.skillIcon1 = skillIcon1;
        this.skillDescription1 = skillDescription1;
        this.skill2 = skill2;
        this.skillIcon2 = skillIcon12;
        this.skillDescription2 = skillDescription2;
        this.skill3 = skill3;
        this.skillIcon3 = skillIcon13;
        this.skillDescription3 = skillDescription3;
    }

    public String getShiShenName() {
        return shiShenName;
    }

    public void setShiShenName(String shiShenName) {
        this.shiShenName = shiShenName;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkillIcon1() {
        return skillIcon1;
    }

    public void setSkillIcon1(String skillIcon1) {
        this.skillIcon1 = skillIcon1;
    }

    public String getSkillDescription1() {
        return skillDescription1;
    }

    public void setSkillDescription1(String skillDescription1) {
        this.skillDescription1 = skillDescription1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getSkillIcon2() {
        return skillIcon2;
    }

    public void setSkillIcon2(String skillIcon2) {
        this.skillIcon2 = skillIcon2;
    }

    public String getSkillDescription2() {
        return skillDescription2;
    }

    public void setSkillDescription2(String skillDescription2) {
        this.skillDescription2 = skillDescription2;
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public String getSkillIcon3() {
        return skillIcon3;
    }

    public void setSkillIcon3(String skillIcon3) {
        this.skillIcon3 = skillIcon3;
    }

    public String getSkillDescription3() {
        return skillDescription3;
    }

    public void setSkillDescription3(String skillDescription3) {
        this.skillDescription3 = skillDescription3;
    }
}
