package com.yys.dao.impl;

import com.yys.dao.IShiShenDao;
import com.yys.entity.ShiShen;
import com.yys.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ShiShenDaoImpl implements IShiShenDao {
    private DBHelper dbHelper;
    private Connection connection;

    public ShiShenDaoImpl() {
        dbHelper = new DBHelper();
        connection = dbHelper.getConnection();
    }

    /**
     * 查询单个式神图标信息
     *
     * @param name 查询式神名
     * @return 信息
     */
    @Override
    public ArrayList<ShiShen> QueryShiShenByName(String name) {
        ArrayList<ShiShen> ret = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from shishen where shiShenName like ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ShiShen s = new ShiShen(
                        resultSet.getString("shiShenName"),
                        resultSet.getString("jueXingQianIcon"),
                        resultSet.getString("jueXingHouIcon")
                );
                ret.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 查询所有式神信息
     *
     * @return 所有式神信息
     */
    @Override
    public ArrayList<ShiShen> QueryShiShen() {
        ArrayList<ShiShen> ret = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from shishen";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ret.add(new ShiShen(
                        resultSet.getString("shiShenName"),
                        resultSet.getString("jueXingQianIcon"),
                        resultSet.getString("jueXingHouIcon")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 添加式神信息
     *
     * @param newData 新数据
     * @return true：成功 false：失败
     */
    @Override
    public boolean AddShiShen(ShiShen newData) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String sql = "insert into shishen values(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newData.getShiShenName());
            preparedStatement.setString(2, newData.getJueXingQianIcon());
            preparedStatement.setString(3, newData.getJueXingHouIcon());
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
     * 删除式神信息
     *
     * @param name 需要删除的式神名
     * @return true：成功 false：失败
     */
    @Override
    public boolean DeleteShiShen(String name) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String sql = "delete from shishen where shiShenName=?";
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

    /**
     * 修改式神信息
     *
     * @param newData 新信息
     * @return true：成功 false：失败
     */
    @Override
    public boolean UpdateShiShen(ShiShen newData) {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String sql = "update shishen set shiShenName=?,jueXingQianIcon=?,jueXingHouIcon=? where shiShenName=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newData.getShiShenName());
            preparedStatement.setString(2, newData.getJueXingQianIcon());
            preparedStatement.setString(3, newData.getJueXingHouIcon());
            preparedStatement.setString(4, newData.getShiShenName());
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
