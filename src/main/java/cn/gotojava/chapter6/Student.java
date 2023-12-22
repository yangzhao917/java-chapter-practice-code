package cn.gotojava.chapter6;

/**
 * description：学生类，该类继承自Person
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Student extends Person{
    // 数学成绩
    private double math;
    // 英语成绩
    private double english;

    public Student() {
    }

    public Student(double math, double english) {
        this.math = math;
        this.english = english;
    }

    public Student(String name, String addr, char sex, int age, double math, double english) {
        super(name, addr, sex, age);
        this.math = math;
        this.english = english;
    }

    public double getMath() {
        return math;
    }

    public Student setMath(double math) {
        this.math = math;
        return this;
    }

    public double getEnglish() {
        return english;
    }

    public Student setEnglish(double english) {
        this.english = english;
        return this;
    }

    /**
     * 打印属性
     * @return
     */
    @Override
    public String print() {
        return "学生{" +
                "姓名='" + super.getName() + '\'' +
                ", 地址='" + super.getAddr() + '\'' +
                ", 性别=" + super.getSex() +
                ", 年龄=" + super.getAge() +
                ", 数学成绩=" + this.math +
                ", 英语成绩=" + this.english +
                '}';
    }
}
