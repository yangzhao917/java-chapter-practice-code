package cn.gotojava.chapter6;

/**
 * description：人类
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Person {

    // 姓名
    private String name;
    // 地址
    private String addr;
    // 性别
    private char sex;
    // 年龄
    private int age;

    public Person() {
    }

    public Person(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person(String name, String addr, char sex, int age) {
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddr() {
        return addr;
    }

    public Person setAddr(String addr) {
        this.addr = addr;
        return this;
    }

    public char getSex() {
        return sex;
    }

    public Person setSex(char sex) {
        this.sex = sex;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    /**
     * 打印属性
     * @return
     */
    public String print() {
        return "Person{" +
                "姓名='" + name + '\'' +
                ", 地址='" + addr + '\'' +
                ", 性别=" + sex +
                ", 年龄=" + age +
                '}';
    }
}
