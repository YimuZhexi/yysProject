package com.yys.dao.impl;

import com.yys.dao.IUserAccountDao;
import com.yys.entity.UserAccount;
import com.yys.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserAccountDaoImpl implements IUserAccountDao {
    DBHelper dbHelper = null;
    Connection conn = null;

    public UserAccountDaoImpl() {
        dbHelper = new DBHelper();
        conn = dbHelper.getConnection();
    }

    /**
     * 查询用户账户
     *
     * @param userName 用户名
     * @return 用户账户
     */
    @Override
    public UserAccount QueryUserAccount(String userName) {
        UserAccount userAccount = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from useraccount where username =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                userAccount = new UserAccount();
                userAccount.setUsername(rs.getString("username"));
                userAccount.setPassword(rs.getString("password"));
                userAccount.setEmail(rs.getString("email"));
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
        return userAccount;
    }

    /**
     * 插入用户账户
     *
     * @param userAccount 用户账户
     * @return 是否插入成功
     */
    @Override
    public boolean InsertUserAccount(UserAccount userAccount) {
        boolean flag = false;
        PreparedStatement ps = null;
        String sql = "insert into useraccount(username,password,email) values(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userAccount.getUsername());
            ps.setString(2, userAccount.getPassword());
            ps.setString(3, userAccount.getEmail());
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
     * 删除用户账户
     *
     * @param userName 用户名
     * @return 是否删除成功
     */
    @Override
    public boolean DeleteUserAccount(String userName) {
        boolean flag = false;
        PreparedStatement ps = null;
        String sql = "delete from useraccount where username =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
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
