package com.yys.dao.impl;

import com.yys.dao.IShiShenZhuanJiDao;
import com.yys.entity.ShiShenZhuanJi;
import com.yys.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShiShenZhuanJiDaoImpl implements IShiShenZhuanJiDao {
    DBHelper dbHelper = null;
    Connection connection = null;

    public ShiShenZhuanJiDaoImpl() {
        dbHelper = new DBHelper();
        connection = dbHelper.getConnection();
    }

    /**
     * 查询式神传记
     *
     * @param name 式神名称
     * @return 式神传记
     */
    @Override
    public ShiShenZhuanJi QueryShiShenZhuanJi(String name) {
        ShiShenZhuanJi shiShenZhuanJi = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from shishenzhuanji where shishenname =?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                shiShenZhuanJi = new ShiShenZhuanJi();
                shiShenZhuanJi.setShiShenName(rs.getString("shishenname"));
                shiShenZhuanJi.setZhuanJi1(rs.getString("zhuanji1"));
                shiShenZhuanJi.setZhuanJi2(rs.getString("zhuanji2"));
                shiShenZhuanJi.setZhuanJi3(rs.getString("zhuanji3"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return shiShenZhuanJi;
    }

    /**
     * 插入式神传记
     *
     * @param shiShenZhuanJi 要插入的式神传记对象
     * @return 插入成功返回true，否则返回false
     */
    @Override
    public boolean AddShiShenZhuanJi(ShiShenZhuanJi shiShenZhuanJi) {
        boolean flag = false;
        PreparedStatement ps = null;
        String sql = "insert into shishenzhuanji values(?,?,?,?)";
        String replace = "update shishenzhuanji set zhuanJi1 = replace(zhuanJi1,'「','﹁')" +
                "and zhuanJi2 = replace(zhuanJi2,'「','﹁')" +
                "and zhuanJi3 = replace(zhuanJi3,'「','﹁')";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, shiShenZhuanJi.getShiShenName());
            ps.setString(2, shiShenZhuanJi.getZhuanJi1());
            ps.setString(3, shiShenZhuanJi.getZhuanJi2());
            ps.setString(4, shiShenZhuanJi.getZhuanJi3());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
            ps = connection.prepareStatement(replace);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 更新式神传记
     *
     * @param shiShenZhuanJi 要更新的式神传记对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean UpdateShiShenZhuanJi(ShiShenZhuanJi shiShenZhuanJi) {
        boolean flag = false;
        PreparedStatement ps = null;
        String sql = "update shishenzhuanji set zhuanji1=?,zhuanji2=?,zhuanji3=? where shishenname=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, shiShenZhuanJi.getZhuanJi1());
            ps.setString(2, shiShenZhuanJi.getZhuanJi2());
            ps.setString(3, shiShenZhuanJi.getZhuanJi3());
            ps.setString(4, shiShenZhuanJi.getShiShenName());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 删除式神传记
     *
     * @param name 要删除的式神名称
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean DeleteShiShenZhuanJi(String name) {
        boolean flag = false;
        PreparedStatement ps = null;
        String sql = "delete from shishenzhuanji where shishenname=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
