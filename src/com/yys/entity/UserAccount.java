package com.yys.entity;

/**
 * 用户账户实体类
 */
public class UserAccount {
    private String username;
    private String password;
    private String email;

    public UserAccount() {
    }

    /**
     *
     * @param username 账户名
     * @param password 账户密码
     * @param email 邮箱
     */
    public UserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     *
     * @return 账户名
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username 账户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
