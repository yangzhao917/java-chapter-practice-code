package cn.gotojava.chapter6;

/**
 * description：管理层类，继承于员工类
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Management extends Employee{

    // 职务
    private String job;
    // 年薪
    private double annualSalary;

    public Management() {
    }

    public Management(String name, int age, char sex, String job, double annualSalary) {
        super(name, age, sex);
        this.job = job;
        this.annualSalary = annualSalary;
    }

    public String getJob() {
        return job;
    }

    public Management setJob(String job) {
        this.job = job;
        return this;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public Management setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
        return this;
    }
}
