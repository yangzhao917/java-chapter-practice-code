package cn.gotojava.chapter6;

/**
 * description：职员类，继承于员工类
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Clerk extends Employee{

    //所属部门
    private String deptName;
    //月薪
    private String monthlySalary;

    public Clerk() {
    }

    public Clerk(String name, int age, char sex, String deptName, String monthlySalary) {
        super(name, age, sex);
        this.deptName = deptName;
        this.monthlySalary = monthlySalary;
    }

    public String getDeptName() {
        return deptName;
    }

    public Clerk setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public String getMonthlySalary() {
        return monthlySalary;
    }

    public Clerk setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
        return this;
    }
}
