package cn.gotojava.chapter5;

import java.io.PipedReader;

/**
 * description：
 *
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class User {

    /** 用户名 */
    private String userName;

    /** 口令 */
    private String password;

    /** 用户总数 */
    private static long userTotal;

    private User() {
    }

    /**
     * 用户名初始化
     * @param userName 用户名
     */
    public User(String userName) {
        this.userName = userName;
        userTotal++;
    }

    /**
     * 用户名和口令初始化
     * @param userName 用户名
     * @param password 口令
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        userTotal++;
    }

    /**
     * 获取口令
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置口令
     * @param password
     * @return
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * 获取用户信息
     * @return
     */
    public String print() {
        return "用户信息{" +
                "用户名='" + userName + '\'' +
                ", 口令='" + password + '\'' +
                ", 用户总数=" + userTotal +
                '}';
    }
}
