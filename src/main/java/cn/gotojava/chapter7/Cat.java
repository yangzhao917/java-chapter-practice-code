package cn.gotojava.chapter7;

/**
 * description：宠物猫
 *
 * @author yangzhao
 * @createBy 2023/12/23
 */
public class Cat implements Pet{

    // 宠物名字
    private String name;

    // 宠物颜色
    private String color;

    // 宠物年龄
    private int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getColor() {
        return color;
    }

    public Cat setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public int getAge() {
        return age;
    }

    public Cat setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "猫{" +
                "姓名='" + name + '\'' +
                ", 颜色='" + color + '\'' +
                ", 年龄=" + age +
                '}';
    }
}
