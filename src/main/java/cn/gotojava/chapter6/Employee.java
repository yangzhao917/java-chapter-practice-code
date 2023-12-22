package cn.gotojava.chapter6;

/**
 * description：员工类
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Employee {

    // 姓名
    private String name;
    // 年龄
    private int age;
    // 性别
    private char sex;

    public Employee() {
    }

    public Employee(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public char getSex() {
        return sex;
    }

    public Employee setSex(char sex) {
        this.sex = sex;
        return this;
    }
}
