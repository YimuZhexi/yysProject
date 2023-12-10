package com.yys.dao;

import com.yys.entity.UserAccount;

public interface IUserAccountDao {
    /**
     * 查询用户账户
     *
     * @param userName 用户名
     * @return 用户账户
     */
    UserAccount QueryUserAccount(String userName);

    /**
     * 插入用户账户
     *
     * @param userAccount 用户账户
     * @return 是否插入成功
     */
    boolean InsertUserAccount(UserAccount userAccount);

    /**
     * 删除用户账户
     *
     * @param userName 用户名
     * @return 是否删除成功
     */
    boolean DeleteUserAccount(String userName);
}
