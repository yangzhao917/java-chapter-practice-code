package cn.gotojava.chapter5;

import java.util.Objects;

/**
 * description：银行账户类
 *
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class Account {

    /** 账户名称 */
    private String name;

    /** 余额 */
    private double balance;

    /**
     * 开户
     * @param name 账户名称
     * @param balance 账户余额
     */
    public Account(String name, double balance) {
        if (Objects.isNull(name) || Objects.isNull(balance) || name.isEmpty()){
            System.out.println("开户信息不能为空");
            return;
        }
        if (balance <= 10){
            System.out.println("开户余额必须大于10元");
            return;
        }
        this.name = name;
        this.balance = balance;
    }

    /**
     * 获取余额
     * @return
     */
    public double getBalance() {
        return balance;
    }
}
