package cn.gotojava.chapter9.computer;

public class Computer {

    private static int producerCount = 0;  // 表示生产的数量
    private String name;    // 电脑名字
    private double price;   // 电脑价格

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
        this.producerCount++;
    }

    @Override
    public String toString() {
        return "生产电脑{" +
                "第" + producerCount + "台电脑" +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}