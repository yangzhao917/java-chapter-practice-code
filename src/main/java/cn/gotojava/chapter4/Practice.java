package cn.gotojava.chapter4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * description：第四章：数组与方法
 *
 * @author yangzhao
 * @createBy 2023/12/20
 */
public class Practice {

    /*
    本章要点：
    1.数组是由一组相同类型的变量所组成的数据类型，它们是以一个共同的名称来表示的。数组按存放元素的复杂程度，分为一维、二维及多维数组。
    2.使用Java中的数组，必须经过声明数组和开辟内存给该数组两个步骤。声明数组时会在栈内存开辟空间，只开辟栈空间的数组是无法使用的，
        必须有指向堆内存空间才能够使用，可以使用new关键字开辟堆内存空间，同时指定开辟的空间大小。
    3.在Java中欲取得数组的长度（也就是数组元素的个数），可以使用"数组名.length"来完成。
    4.数组访问时要使用下标，如果下标的访问超过了数组的范围，则会出现数组越界异常。
    5.Java允许二维数组中每行的元素个数均不相同。
    6.方法是一段可重复调用的代码段，在面向过程编程中称为函数，在面向对象编程中称为方法。
    7.方法的重载：方法名称相同，参数的类型或个数不同，则此方法被称为重载。
    8.数组的传递属于引用数据类型的传递，传递的是堆内存地址的使用权，一个数组可以有多个名称指向同一个堆内存空间，每一个名称都可以修改堆内存中的内容。
    9.Java新特性中提供了可变参数，这样在传递参数的时候就可以不用受到参数的个数限制，全部的参数将以数组的形式保存下来。
    10.foreach是Java中的新特性，主要目的是方便地输出数组中的内容。
     */

    public static void main(String[] args) {
        calculateFactorial1To30();

        countOddOrEvenNumbers(new int[]{1,4,5,8,-12,9,7});

        removeZeros(new int[]{1, 0, 3, 0, 5, 0, 7, 8, 0, 10});

        calculateArray();

        searchArray(new int[]{1, 4, 3, 7, 5, 20, 17, 8, 29, 10});

        assignArrayValues();
    }

    /**
     * 定义一个包含10个元素的数组，对其进行赋值，使每个元素的值等于其下标，然后输出；最后将这个数组倒置（即手尾交换）后输出
     */
    private static void assignArrayValues() {
        int[] paramArr = new int[10];

        for (int i = 0; i < paramArr.length; i++) {
            paramArr[i] = i;
        }

        printArrays(paramArr);

        int[] result = reverseArray(paramArr);

        printArrays(result);
    }

    /**
     * 数组倒置（手尾交换）
     * @param paramArr 数组参数
     */
    private static int[] reverseArray(int[] paramArr) {
        if (paramArr.length == 0){
            return new int[paramArr.length];
        }

        // 起始索引标记
        int begin = 0;
        // 结束索引标记
        int end = paramArr.length - 1;
        for (int i = 0; i < paramArr.length; i++) {
            if (begin > end){
                break;
            }
            // 交换首尾元素
            int temp = paramArr[begin];
            paramArr[begin] = paramArr[end];
            paramArr[end] = temp;

            // 移动索引
            begin++;
            end--;
        }

        return paramArr;
    }

    /**
     * 打印数组元素
     * @param param 数组参数
     */
    private static void printArrays(int[] param) {
        for (int i = 0; i < param.length; i++) {
            System.out.print(param[i] + ",");
        }
        System.out.println();
    }

    /**
     * 给出10个整型（int）型，然后任意查询一个数字是否存在该10个数字内
     */
    private static void searchArray(int[] param) {
        if (param.length == 0){
            System.out.println("数组参数不能为空");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int inputVal = scanner.nextInt();
        if (inputVal < 0){
            searchArray(param);
        }else {
            String status = searchNumber(inputVal, param) ? "存在" : "不存在";
            System.out.println(String.format("数组参数：%s，搜索的数字：%s，是否存在：%s", Arrays.toString(param), inputVal, status));
        }
    }

    /**
     * 在数组中搜索指定的数字
     * @param value 整型数组
     * @param param 搜索的数字
     */
    private static boolean searchNumber(int value, int[] param) {
        boolean flag = false;

        for (int val : param) {
            if (val != value){
                continue;
            }
            flag = true;
            break;
        }

        return flag;
    }

    /**
     * 定义一个整型数组，求出数组元素的和、数组元素的最大值和最小值，并输出所求的结果。
     */
    private static void calculateArray() {
        int[] param = new int[]{1,3,5,10,12,4,9,19};

        // 计算数组元素的和
        int sum = calculateSum(param);
        int max = findMax(param);
        int min = findMin(param);
        System.out.println(String.format("数组参数%s，最大值：%s、最小值：%s、总和：%s", Arrays.toString(param), max, min, sum));
    }

    /**
     * 计算数组元素最小值
     * @param param 数组参数
     * @return 数组元素最小值
     */
    private static int findMin(int[] param) {
        int min = param[0];
        for (int val : param) {
            if (val < min){
                min = val;
            }
        }
        return min;
    }

    /**
     * 计算数组元素的最大值
     * @param param 数组参数
     * @return 数组元素最大值
     */
    private static int findMax(int[] param) {
        int max = param[0];
        for (int val : param) {
            if (val > max){
                max = val;
            }
        }
        return max;
    }

    /**
     * 计算数组元素的和
     */
    private static int calculateSum(int[] param) {
        int total = 0;
        for (int i = 0; i < param.length; i++) {
            total += param[i];
        }
        return total;
    }

    /**
     * 将数组中值为0的项去掉，将不为0的值存入一个新的数组
     */
    private static void removeZeros(int[] arr) {
        System.out.println(String.format("原数组：%s", Arrays.toString(arr)));

        // 存储数组中不为0的元素个数
        int count = 0;

        for (int i : arr) {
            if (i != 0){
                count++;
            }
        }

        // 定义一个新数组，用于存储不为0的元素
        int[] newArr = new int[count];

        // 新数组的下标，原数组元素包含0，与新数组长度不一样
        int index = 0;
        // 将不为0的数组元素内容拷贝到新数组中
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                newArr[index++] = arr[i];
            }
        }

        System.out.println(String.format("新数组：%s", Arrays.toString(newArr)));
    }

    /**
     * 求出其中的奇数个数和偶数个数。
     * @param arr 整数数组
     */
    private static void countOddOrEvenNumbers(int[] arr) {
        // 奇数统计
        int countOdd = 0;
        // 偶数统计
        int countEvent = 0;

        if (arr.length == 0){
            System.out.println("参数不能为空");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 计算偶数
            if (arr[i] % 2 == 0){
                countEvent++;
            }else {
                // 计算奇数
                countOdd++;
            }
        }
        System.out.println(String.format("数组为：%s => 奇数：%s个、偶数：%s个", Arrays.toString(arr), countOdd, countEvent));
    }

    /**
     * 编写程序求1!+2!+...+30!的和并显示
     */
    private static void calculateFactorial1To30(){
        long totalNum = 0;
        for (int i = 1; i <= 30; i++) {
            totalNum += calculateFactorial(i);
        }
        System.out.println(String.format("1!+2!+...+30!的和：%s", totalNum));
    }

    /**
     * 计算一个数的阶乘
     * @param n number
     * @return 该数的阶乘
     */
    private static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            long factorial = 1;
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
