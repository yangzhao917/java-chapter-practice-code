package cn.gotojava.chapter5;

/**
 * description：
 *
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class Dog {

    /**名字*/
    private String name;
    /**颜色*/
    private String color;
    /**年龄*/
    private int age;

    public Dog() {
    }

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public Dog setColor(String color) {
        this.color = color;
        return this;
    }

    public Dog setAge(int age) {
        this.age = age;
        return this;
    }

    /**
     * 获取狗信息
     * @return
     */
    public String print() {
        return "狗{" +
                "姓名='" + name + '\'' +
                ", 颜色='" + color + '\'' +
                ", 年龄=" + age + "岁" +
                '}';
    }
}
