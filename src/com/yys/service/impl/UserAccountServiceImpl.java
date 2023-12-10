package com.yys.service.impl;

import com.yys.dao.IUserAccountDao;
import com.yys.entity.UserAccount;
import com.yys.service.IUserAccountService;
import com.yys.factory.DaoFactory;

/**
 * 用户账户服务实现类
 */
public class UserAccountServiceImpl implements IUserAccountService {
    IUserAccountDao userAccountDao = DaoFactory.getUserAccountDao();

    /**
     * 插入用户账户
     *
     * @param userAccount 要插入的用户账户对象
     * @return 如果插入成功返回true，否则返回false
     */
    @Override
    public boolean InsertUserAccount(UserAccount userAccount) {
        if (userAccount != null) {
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
            // 调用数据访问对象的方法删除用户账户
            return userAccountDao.DeleteUserAccount(userName);
        }
        // 如果用户名为空，删除失败
        return false;
    }

    /**
     * 登录
     *
     * @param userName 账户的用户名
     * @param password 账户的密码
     * @return 密码账户匹配则返回true，否则返回false
     */
    @Override
    public boolean LoginAccount(String userName, String password) {
        // 登录账户方法，传入用户名和密码，判断是否登录成功
        if (userName != null && password != null) {
            // 调用用户账户数据访问对象的方法查询用户账户
            UserAccount data = userAccountDao.QueryUserAccount(userName);
            return data.getPassword().equals(password);
        }
        return false;
    }
}
