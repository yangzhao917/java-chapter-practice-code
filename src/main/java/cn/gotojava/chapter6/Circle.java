package cn.gotojava.chapter6;

/**
 * description：圆形
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Circle extends Shape{

    /** 半径 */
    private double radius;

    /**
     * 初始化参数
     * @param color 颜色
     * @param shapeName 图形名称
     * @param radius 半径
     */
    public Circle(String color, String shapeName, double radius) {
        super(color, shapeName);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * 获取半径
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * 设置半径
     * @param radius 半径值
     * @return
     */
    public Circle setRadius(double radius) {
        this.radius = radius;
        return this;
    }
}
