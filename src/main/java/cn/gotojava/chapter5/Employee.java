package cn.gotojava.chapter5;

/**
 * description：员工的Employee类。员工属性包括"编号"、"姓名"、"基本薪水"和"薪水增长额"，还包括计算薪水增长额及计算增长后的工资总额的操作方法
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class Employee {
    /** 编号 */
    private Long no;

    /**姓名*/
    private String name;

    /**基本薪水*/
    private double baseSalary;

    /**增长额*/
    private double salaryIncr;

    /**员工部门*/
    private String deptName;

    public Employee() { }

    public Employee(Long no) {
        this.no = no;
        this.baseSalary = 0;
    }

    public Employee(Long no, String name) {
        this.no = no;
        this.name = name;
        this.baseSalary = 1000;
        this.deptName = "后勤";
    }

    public Employee(Long no, String name, double baseSalary, String deptName) {
        this.no = no;
        this.name = name;
        this.baseSalary = baseSalary;
        this.deptName = deptName;
    }

    public Employee(Long no, String name, double baseSalary, double salaryIncr) {
        this.no = no;
        this.name = name;
        this.baseSalary = baseSalary;
        this.salaryIncr = salaryIncr;
    }

    /**
     * 计算增长额（增长额=基本工资 * (增长额 / 100)）
     * @return
     */
    public double calculateSalaryIncrease(){
        return baseSalary * (salaryIncr / 100);
    }

    /**
     * 工资总额
     * @return
     */
    public double calculateTotalSalary(){
        return baseSalary + calculateSalaryIncrease();
    }

    /**
     * 获取员工信息
     * @return 员工信息
     */
    public String print() {
        return "{" +
                "员工编号=" + no +
                ", 员工姓名='" + name + '\'' +
                ", 员工部门='" + deptName + '\'' +
                ", 基本工资=￥" + baseSalary +
                ", 工资增长率=" + salaryIncr + "%%" +
                '}';
    }
}
