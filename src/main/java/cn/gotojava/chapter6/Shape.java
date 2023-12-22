package cn.gotojava.chapter6;

/**
 * description：图形类
 * @author yangzhao
 * @createBy 2023/12/22
 */
public abstract class Shape {

    /** 颜色 */
    private String color;

    /** 是否填充 */
    private boolean filled;

    /** 形状 */
    private String shapeName;

    /**
     * 初始化参数
     * @param color 颜色
     * @param shapeName 形状名称
     */
    public Shape(String color, String shapeName) {
        this(color, shapeName, false);
    }

    /**
     * 初始化图形参数
     * @param color 颜色
     * @param shapeName 形状名称
     * @param filled 是否填充
     */
    public Shape(String color, String shapeName, boolean filled) {
        this.color = color;
        this.shapeName = shapeName;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public Shape setColor(String color) {
        this.color = color;
        return this;
    }

    public boolean isFilled() {
        return filled;
    }

    public Shape setFilled(boolean filled) {
        this.filled = filled;
        return this;
    }

    public String getShapeName() {
        return shapeName;
    }

    public Shape setShapeName(String shapeName) {
        this.shapeName = shapeName;
        return this;
    }

    /**
     * 计算面积
     * @return
     */
    public abstract double area();

    /**
     * 计算周长
     * @return
     */
    public abstract double perimeter();
}
