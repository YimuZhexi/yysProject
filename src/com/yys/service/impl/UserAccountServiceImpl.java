package com.yys.service.impl;

import com.yys.dao.IUserAccountDao;
import com.yys.entity.UserAccount;
import com.yys.service.IUserAccountService;
import com.yys.factory.DaoFactory;

public class UserAccountServiceImpl implements IUserAccountService {
    /**
     * 插入用户账户
     *
     * @param userAccount 要插入的用户账户对象
     * @return 如果插入成功返回true，否则返回false
     */
    @Override
    public boolean InsertUserAccount(UserAccount userAccount) {
        if (userAccount != null) {
            // 获取用户账户数据访问对象
            IUserAccountDao userAccountDao = DaoFactory.getUserAccountDao();
            if (userAccount.getUsername() != null && userAccount.getPassword() != null && userAccount.getEmail() != null)
                // 执行插入操作
                return userAccountDao.InsertUserAccount(userAccount);
        }
        // 如果用户账户为空，则返回false
        return false;
    }


    /**
     * 删除用户账户
     *
     * @param userName 要删除的用户账户的用户名
     * @return 如果删除成功返回true，否则返回false
     */
    @Override
    public boolean DeleteUserAccount(String userName) {
        if (userName != null) {
            // 获取用户账户数据访问对象
            IUserAccountDao userAccountDao = DaoFactory.getUserAccountDao();
            // 调用数据访问对象的方法删除用户账户
            return userAccountDao.DeleteUserAccount(userName);
        }
        // 如果用户名为空，删除失败
        return false;
    }


    /**
     * 查询用户账户
     *
     * @param userName 要查询的用户账户的用户名
     * @return 如果找到对应用户账户返回UserAccount对象，否则返回null
     */
    @Override
    public UserAccount QueryUserAccount(String userName) {
        if (userName != null) {
            // 获取用户账户数据访问对象
            IUserAccountDao userAccountDao = DaoFactory.getUserAccountDao();
            // 调用用户账户数据访问对象的方法查询用户账户
            return userAccountDao.QueryUserAccount(userName);
        }
        // 如果用户名为空，则返回null
        return null;
    }

}
