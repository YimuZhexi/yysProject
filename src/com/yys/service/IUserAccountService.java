package com.yys.service;

import com.yys.entity.UserAccount;

/**
 * 用户账户服务接口
 */
public interface IUserAccountService {
    /**
     * 插入用户账户
     *
     * @param userAccount 要插入的用户账户对象
     * @return 如果插入成功返回true，否则返回false
     */
    public boolean InsertUserAccount(UserAccount userAccount);

    /**
     * 删除用户账户
     *
     * @param userName 要删除的用户账户的用户名
     * @return 如果删除成功返回true，否则返回false
     */
    public boolean DeleteUserAccount(String userName);

    /**
     * 查询用户账户
     *
     * @param userName 要查询的用户账户的用户名
     * @return 如果找到对应用户账户返回UserAccount对象，否则返回null
     */
    public UserAccount QueryUserAccount(String userName);
}

