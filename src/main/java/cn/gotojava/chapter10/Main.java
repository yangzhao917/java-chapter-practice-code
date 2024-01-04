package cn.gotojava.chapter10;

/**
 * 第十章：泛型
 */
public class Main {

    /*
    本章要点：
    1.泛型可以使程序的操作更加安全，避免发生类转换异常。
    2.在程序中如果使用类时没有指定泛型，则泛型将被删除，而使用Object接收参数。
    3.可以使用通配符"？"接收全部的泛型类型对象。
    4.通过<? extends 类>可以设置泛型的上限，通过<? super 类>可以设置泛型的下限。
    5.泛型方法可以定义在泛型类中，也可以定义在普通类中。
    6.泛型也可以在接口中定义，实现泛型接口的子类要指明具体的泛型类型。
    7.泛型可以嵌套使用。
    8。在程序中定义没有方法的接口，这样的接口一般称为标识接口。
     */

    public static void main(String[] args) {
        // 按照要求定义一个操作类：要求完成一个一维数组操作类，其中可以加入任意类型的数据，数组的具体操作类型由程序外部决定，并且可以实现查询功能。
        ArrayOperation<String> arrayOperation = new ArrayOperation<>(5);

        // 添加元素
        arrayOperation.addElement(0, "Element1");
        arrayOperation.addElement(2, "Element2");

        // 查询元素
        int index = arrayOperation.indexOf("Element2");
        if (index != -1) {
            System.out.println(String.format("元素存在，索引位置:%s ", index));
        } else {
            System.out.println("元素不存在于索引中");
        }
    }
}
