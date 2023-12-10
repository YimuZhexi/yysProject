package com.yys.dao.impl;

import com.yys.dao.IShiShenAttributeDao;
import com.yys.entity.ShiShenAttribute;
import com.yys.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShiShenAttributeDaoImpl implements IShiShenAttributeDao {
    private DBHelper dbHelper;
    private Connection connection;

    public ShiShenAttributeDaoImpl() {
        dbHelper = new DBHelper();
        connection = dbHelper.getConnection();
    }

    /**
     * 获取式神详情（包含觉醒前和觉醒后）
     *
     * @param name 式神名
     * @return 两个状态的信息
     */
    @Override
    public ArrayList<ShiShenAttribute> QueryByName(String name) {
        ArrayList<ShiShenAttribute> ret = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from shishenattribute where shiShenName=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ShiShenAttribute shiShen = new ShiShenAttribute();
                shiShen.setShiShenName(resultSet.getString("shiShenName"));
                shiShen.setBaoJi(resultSet.getFloat("baoJi"));
                shiShen.setBaoJiShangHai(resultSet.getFloat("baoJiShangHai"));
                shiShen.setFangYu(resultSet.getInt("fangYu"));
                shiShen.setGongJi(resultSet.getInt("gongJi"));
                shiShen.setShengMing(resultSet.getInt("shengMing"));
                shiShen.setSuDu(resultSet.getInt("suDu"));
                shiShen.setZhuangTai(resultSet.getString("zhuangTai"));
                shiShen.setXiaoGuoDiKang(resultSet.getFloat("xiaoGuoDiKang"));
                shiShen.setXiaoGuoMingZhong(resultSet.getFloat("xiaoGuoMingZhong"));
                shiShen.setImage(resultSet.getBytes("image"));
                ret.add(shiShen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();

                if (preparedStatement != null) preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 添加式神信息
     *
     * @param shiShenAttribute 新的式神信息
     * @return true：成功
     * false：失败
     */
    @Override
    public boolean AddShiShenAttribute(ShiShenAttribute shiShenAttribute) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String sql = "insert into shiShenAttribute(" +
                "shiShenName," +
                "baoJi," +
                "baoJiShangHai," +
                "fangYu," +
                "gongJi," +
                "shengMing," +
                "suDu," +
                "zhuangTai," +
                "xiaoGuoDiKang," +
                "xiaoGuoMingZhong," +
                "image) " +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shiShenAttribute.getShiShenName());
            preparedStatement.setFloat(2, shiShenAttribute.getBaoJi());
            preparedStatement.setFloat(3, shiShenAttribute.getBaoJiShangHai());
            preparedStatement.setInt(4, shiShenAttribute.getFangYu());
            preparedStatement.setInt(5, shiShenAttribute.getGongJi());
            preparedStatement.setInt(6, shiShenAttribute.getShengMing());
            preparedStatement.setInt(7, shiShenAttribute.getSuDu());
            preparedStatement.setString(8, shiShenAttribute.getZhuangTai());
            preparedStatement.setFloat(9, shiShenAttribute.getXiaoGuoDiKang());
            preparedStatement.setFloat(10, shiShenAttribute.getXiaoGuoMingZhong());
            preparedStatement.setBytes(11, shiShenAttribute.getImage());
            if (preparedStatement.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 修改式神信息
     *
     * @param shiShenAttribute 修改后的信息
     * @return true：成功
     * false：失败
     */
    @Override
    public boolean UpdateShiShenAttribute(ShiShenAttribute shiShenAttribute) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String sql = "update shishenattribute set" +
                " baoji=?," +
                "baojishanghai=?," +
                "fangyu=?," +
                "gongji=?," +
                "shengming=?," +
                "sudu=?," +
                "zhuangtai=?," +
                "xiaoguodikang=?," +
                "xiaoguomingzhong=?," +
                "image=? " +
                " where shishenname=? " +
                "and zhuangTai=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, shiShenAttribute.getBaoJi());
            preparedStatement.setFloat(2, shiShenAttribute.getBaoJiShangHai());
            preparedStatement.setInt(3, shiShenAttribute.getFangYu());
            preparedStatement.setInt(4, shiShenAttribute.getGongJi());
            preparedStatement.setInt(5, shiShenAttribute.getShengMing());
            preparedStatement.setInt(6, shiShenAttribute.getSuDu());
            preparedStatement.setString(7, shiShenAttribute.getZhuangTai());
            preparedStatement.setFloat(8, shiShenAttribute.getXiaoGuoDiKang());
            preparedStatement.setFloat(9, shiShenAttribute.getXiaoGuoMingZhong());
            preparedStatement.setString(11, shiShenAttribute.getShiShenName());
            preparedStatement.setBytes(10, shiShenAttribute.getImage());
            preparedStatement.setString(12, shiShenAttribute.getZhuangTai());
            if (preparedStatement.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();

                ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 删除式神信息
     *
     * @param name 需要删除的式神名
     * @return true：成功
     * false：失败
     */
    @Override
    public boolean DeleteShiShenAttributeByName(String name) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM shishenattribute WHERE shiShenName = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            if (preparedStatement.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
