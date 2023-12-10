package com.yys.dao.impl;

import com.yys.dao.IShiShenSkillDao;
import com.yys.entity.ShiShenSkill;
import com.yys.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShiShenSkillDaoImpl implements IShiShenSkillDao {
    private DBHelper dbHelper;
    private Connection connection;

    public ShiShenSkillDaoImpl() {
        dbHelper = new DBHelper();
        connection = dbHelper.getConnection();
    }

    /**
     * 查询技能
     *
     * @param name 式神名称
     * @return 技能
     */
    @Override
    public ShiShenSkill QueryShiShenSkill(String name) {
        ShiShenSkill shiShenSkill = null;  // 创建一个空的ShiShenSkill对象
        PreparedStatement preparedStatement = null;  // 创建一个PreparedStatement对象，并初始化为null
        ResultSet resultSet = null;  // 创建一个ResultSet对象，并初始化为null
        String sql = "select * from shishenskill where shishenname =?";  // SQL查询语句

        try {
            preparedStatement = connection.prepareStatement(sql);  // 使用连接对象和SQL查询语句创建一个PreparedStatement对象
            preparedStatement.setString(1, name);  // 设置PreparedStatement对象的参数为name变量的值
            resultSet = preparedStatement.executeQuery();  // 执行SQL查询语句并返回结果集
            while (resultSet.next()) {  // 当结果集的指针向下移动一行时，执行循环
                shiShenSkill = new ShiShenSkill();  // 创建一个新的ShiShenSkill对象
                shiShenSkill.setShiShenName(resultSet.getString("shishenname"));  // 将结果集中的shishenname列的值赋给shiShenSkill的shishenname属性
                shiShenSkill.setSkill1(resultSet.getString("skill1"));  // 将结果集中的skill1列的值赋给shiShenSkill的skill1属性
                shiShenSkill.setSkillIcon1(resultSet.getBytes("skillIcon1"));  // 将结果集中的skillIcon1列的值赋给shiShenSkill的skillIcon1属性
                shiShenSkill.setSkillDescription1(resultSet.getString("skillDescription1"));  // 将结果集中的skillDescription1列的值赋给shiShenSkill的skillDescription1属性
                shiShenSkill.setSkill2(resultSet.getString("skill2"));  // 将结果集中的skill2列的值赋给shiShenSkill的skill2属性
                shiShenSkill.setSkillIcon2(resultSet.getBytes("skillIcon2"));  // 将结果集中的skillIcon2列的值赋给shiShenSkill的skillIcon2属性
                shiShenSkill.setSkillDescription2(resultSet.getString("skillDescription2"));  // 将结果集中的skillDescription2列的值赋给shiShenSkill的skillDescription2属性
                shiShenSkill.setSkill3(resultSet.getString("skill3"));  // 将结果集中的skill3列的值赋给shiShenSkill的skill3属性
                shiShenSkill.setSkillIcon3(resultSet.getBytes("skillIcon3"));  // 将结果集中的skillIcon3列的值赋给shiShenSkill的skillIcon3属性
                shiShenSkill.setSkillDescription3(resultSet.getString("skillDescription3"));  // 将结果集中的skillDescription3列的值赋给shiShenSkill的skillDescription3属性
            }
        } catch (Exception e) {
            e.printStackTrace();  // 打印异常信息
        } finally {
            try {
                if (resultSet != null) resultSet.close();  // 关闭结果集
                if (preparedStatement != null) preparedStatement.close();  // 关闭PreparedStatement对象
            } catch (Exception e) {
                e.printStackTrace();  // 打印异常信息
            }
        }
        return shiShenSkill;  // 返回shiShenSkill对象

    }

    /**
     * 添加技能
     *
     * @param shiShenSkill 技能
     * @return 是否成功
     */
    @Override
    public boolean InsertShiShenSkill(ShiShenSkill shiShenSkill) {
        boolean flag = false;  // 定义一个布尔变量flag并初始化为false
        PreparedStatement preparedStatement = null;  // 定义一个PreparedStatement对象preparedStatement并初始化为null
        String sql = "insert into shishenskill values(?,?,?,?,?,?,?,?,?,?)";  // 定义一个字符串变量sql并初始化为插入语句
        try {
            preparedStatement = connection.prepareStatement(sql);  // 用连接对象connection的prepareStatement方法创建一个PreparedStatement对象并赋值给preparedStatement
            preparedStatement.setString(1, shiShenSkill.getShiShenName());  // 调用preparedStatement的setString方法并传入参数1和shiShenSkill对象的shiShenName属性值
            preparedStatement.setString(2, shiShenSkill.getSkill1());  // 调用preparedStatement的setString方法并传入参数2和shiShenSkill对象的skill1属性值
            preparedStatement.setBytes(3, shiShenSkill.getSkillIcon1());  // 调用preparedStatement的setBytes方法并传入参数3和shiShenSkill对象的skillIcon1属性值
            preparedStatement.setString(4, shiShenSkill.getSkillDescription1());  // 调用preparedStatement的setString方法并传入参数4和shiShenSkill对象的skillDescription1属性值
            preparedStatement.setString(5, shiShenSkill.getSkill2());  // 调用preparedStatement的setString方法并传入参数5和shiShenSkill对象的skill2属性值
            preparedStatement.setBytes(6, shiShenSkill.getSkillIcon2());  // 调用preparedStatement的setBytes方法并传入参数6和shiShenSkill对象的skillIcon2属性值
            preparedStatement.setString(7, shiShenSkill.getSkillDescription2());  // 调用preparedStatement的setString方法并传入参数7和shiShenSkill对象的skillDescription2属性值
            preparedStatement.setString(8, shiShenSkill.getSkill3());  // 调用preparedStatement的setString方法并传入参数8和shiShenSkill对象的skill3属性值
            preparedStatement.setBytes(9, shiShenSkill.getSkillIcon3());  // 调用preparedStatement的setBytes方法并传入参数9和shiShenSkill对象的skillIcon3属性值
            preparedStatement.setString(10, shiShenSkill.getSkillDescription3());  // 调用preparedStatement的setString方法并传入参数10和shiShenSkill对象的skillDescription3属性值
            if (preparedStatement.executeUpdate() > 0) {  // 调用preparedStatement的updateQuery方法执行SQL语句并判断返回的更新行数是否大于0
                flag = true;  // 如果更新行数大于0，则将flag赋值为true
            }
        } catch (Exception e) {  // 捕获异常
            e.printStackTrace();  // 打印异常堆栈信息
        } finally {  // 最终执行的代码块
            try {
                if (preparedStatement != null) preparedStatement.close();  // 如果preparedStatement对象不为null，则关闭连接
            } catch (Exception e) {
                e.printStackTrace();  // 打印异常堆栈信息
            }
        }
        return flag;  // 返回flag变量的值

    }

    /**
     * 修改技能
     *
     * @param shiShenSkill 技能
     * @return 是否成功
     */
    @Override
    public boolean UpdateShiShenSkill(ShiShenSkill shiShenSkill) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String sql = "update shishenskill set " +
                "skill1=?,skillIcon1=?,skillDescription1=?," +
                "skill2=?,skillIcon2=?,skillDescription2=?," +
                "skill3=?,skillIcon3=?,skillDescription3=? " +
                "where shishenname=?";
        try {
            // 准备SQL语句并使用参数替换占位符
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shiShenSkill.getSkill1()); // 设置技能1
            preparedStatement.setBytes(2, shiShenSkill.getSkillIcon1()); // 设置技能1图标
            preparedStatement.setString(3, shiShenSkill.getSkillDescription1()); // 设置技能1描述
            preparedStatement.setString(4, shiShenSkill.getSkill2()); // 设置技能2
            preparedStatement.setBytes(5, shiShenSkill.getSkillIcon2()); // 设置技能2图标
            preparedStatement.setString(6, shiShenSkill.getSkillDescription2()); // 设置技能2描述
            preparedStatement.setString(7, shiShenSkill.getSkill3()); // 设置技能3
            preparedStatement.setBytes(8, shiShenSkill.getSkillIcon3()); // 设置技能3图标
            preparedStatement.setString(9, shiShenSkill.getSkillDescription3()); // 设置技能3描述
            preparedStatement.setString(10, shiShenSkill.getShiShenName()); // 设置式神名
            // 执行SQL语句并返回更新的行数
            if (preparedStatement.executeUpdate() > 0) {
                flag = true; // 更新成功
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close(); // 关闭PreparedStatement对象
            } catch (Exception e) {
                e.printStackTrace(); // 输出异常信息
            }
        }
        return flag; // 返回更新标志

    }

    /**
     * 删除技能
     *
     * @param name 式神名称
     * @return 是否成功
     */
    @Override
    public boolean DeleteShiShenSkill(String name) {
        boolean flag = false;  // 定义一个布尔变量flag并初始化为false
        PreparedStatement preparedStatement = null;  // 定义一个PreparedStatement类型的变量preparedStatement并初始化为null
        String sql = "delete from shishenskill where shishenname=?";  // 定义一个字符串变量sql并赋值为"delete from shishenskill where shishenname=?"
        try {
            preparedStatement = connection.prepareStatement(sql);  // 通过预编译方式创建一个Statement对象preparedStatement，并将SQL语句赋值为sql
            preparedStatement.setString(1, name);  // 设置preparedStatement的第一个参数为name
            if (preparedStatement.executeUpdate() > 0) {  // 如果preparedStatement执行的更新操作的行数大于0
                flag = true;  // 将flag设置为true
            }
        } catch (Exception e) {  // 捕获所有异常并存储在变量e中
            e.printStackTrace();  // 打印异常堆栈信息
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();  // 如果preparedStatement不为null，则关闭preparedStatement
            } catch (Exception e) {
                e.printStackTrace();  // 打印异常堆栈信息
            }
        }
        return flag;  // 返回flag的值
    }
}
