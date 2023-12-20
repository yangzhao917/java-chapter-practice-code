package cn.gotojava.chapter3;

/**
 * description：第三章：Java基础程序设计
 *
 * @author yangzhao
 * @createBy 2023/12/20
 */
public class Practice {

    /*
    本章要点：
    1.Java的数据类型可分为基本数据类型和引用数据类型两种。
    2.Unicode为每个字符制定了一个唯一的数值，在任何的语言、平台、程序都可以安心的使用。
    3.布尔（boolean）类型的变量，只有true（真）和false（假）两个值。
    4.数据类型的转换可分为"自动类型转换"与"强制类型转换"两种。
    5.算术运算符的成员有加法运算符、减法运算符、乘法运算符、除法运算符、余数运算符。
    6.if语句可依据判断的结果来决定程序的流程。
    7.自增与自减运算符有着相当大的便利性，善用它们可提高程序的简洁程度。
    8.括号是用来处理表达式的优先级的，也是Java的运算符。
    9.当表达式中有类型不匹配时，有下列的处理方法：
        1）占用较少字节的数据类型会转换成占用较多字节的数据类型。
        2）有short和int类型，则用int类型。
        3）字符类型会转换成short类型。
        4）int类型转换成float类型。
        5）若一个操作数的类型为double，则其他的操作数也会转换成double类型。
        6）布尔类型不能转换至其他的类型。
    10.程序的结构包含顺序结构、选择结构、循环结构。
    11.需要重复执行某项功能时，循环就是最好的选择。可以根据程序的需求与习惯，选择使用Java所提供的for、while及do...while循环来完成。
    12.break语句可以让强制程序逃离循环。当程序运行到break语句时，即会离开循环，继续执行循环外的下一个语句，如果break语句出现在嵌套循环中的内层循环，
    则break语句只会离开当前层循环。
    13.continue语句可以强制程序跳到循环的起始处，当程序运行到continue语句时，即会停止运行剩余的循环主体，而到循环的开始处继续运行。
    14.选择结构包括了if、if...else及switch语句，语句中加上选择的结构后，就像是十字路口，根据不同的选择程序的运行会有不同的方向与结果。
    15.在循环里也可以声明变量，但所声明的变量只是局部变量，只要跳出循环，这个变量就不能再使用了。
    */

    public static void main(String[] args) {
        printNarcissisticNumber();

        twoDigitExchange(-2, 5);

        printMaxVal(1, 19, 9);

        isDivisibleBy357(13);

        calculateSumInRange();

        calculateSeriesSum();

        calculateSum1To100();

        findNumbersDivisibleBy357();

        calculateFactorialSum();

        printPositiveTriangle();
    }

    private static void printPositiveTriangle() {
        // 三角形行数
        int rows = 5;

        for (int i = rows; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = rows; k >= i; k--) {
                System.out.print("*");
            }
            // 换行
            System.out.println();
        }
    }

    /**
     * 求1!+2!+3!+...20!的值
     */
    private static void calculateFactorialSum() {
        long factorial = 0;
        for (int i = 1; i <= 20; i++) {
            factorial = calculateFactorial(i);
        }
        System.out.println(String.format("1!+2!+3!+...20!的值：%s", factorial));
    }

    /**
     * 用于找出在1到1000范围内同时可以被3、5、7整除的数字
     */
    private static void findNumbersDivisibleBy357() {
        for (int i = 0; i <= 1000; i++) {
            isDivisibleBy357(i);
        }
    }

    /**
     * 计算1~100的累加
     */
    private static void calculateSum1To100() {
        int total = 0;

        // 定义开始标记和结束标记
        int start = 1;
        int end = 100;
        for (int i = start; i <= end; i++) {
            total += i;
        }

        System.out.println(String.format("1~100的累加和：%s", total));
    }

    /**
     * 求13-23+33-43+....973-983+993-1003的值
     */
    private static void calculateSeriesSum() {
        // 定义开始标记
        int start = 13;
        // 定义结束标记
        int end = 1003;

        int sum = 0;
        // 初始标记：1为正、0为负
        int sign = 1;

        for (int i = start; i <= end; i += 10) {
            sum += sign * i;
            sign = -sign;
        }

        System.out.println(String.format("13-23+33-43+....973-983+993-1003的值：%s", sum));
    }

    /**
     * 求出100~200的累加和
     */
    private static void calculateSumInRange() {
        int forNum = calculateSumInRangeByFor();
        System.out.println(String.format("求出100~200的累加和【for实现】:%s", forNum));

        int whileNum = calculateSumInRangeByWhile();
        System.out.println(String.format("求出100~200的累加和【while实现】:%s", whileNum));

        int doWhileNum = calculateSumInRangeByDoWhile();
        System.out.println(String.format("求出100~200的累加和【do...while实现】:%s", doWhileNum));
    }

    /**
     * 期初100~200的累加和-do...while循环实现
     */
    private static int calculateSumInRangeByDoWhile() {
        // 存储总和
        int totalNum = 0;

        // 定义开始标记和结束标记
        int startIndex = 100;
        int endIndex = 200;

        do {
            totalNum += startIndex;
            startIndex ++;
        } while (startIndex <= endIndex);

        return totalNum;
    }

    /**
     * 期初100~200的累加和-while循环实现
     */
    private static int calculateSumInRangeByWhile() {
        // 存储总和
        int totalNum = 0;

        // 定义开始标记和结束标记
        int startIndex = 100;
        int endIndex = 200;

        while (startIndex <= endIndex){
            totalNum += startIndex;
            startIndex ++;
        }

        return totalNum;
    }

    /**
     * 期初100~200的累加和-for循环实现
     */
    private static int calculateSumInRangeByFor() {
        int totalNum = 0;
        for (int i = 100; i <= 200; i++) {
            totalNum += i;
        }
        return totalNum;
    }

    /**
     * 判断某数能否被3、5、7同时整除
     * @param val 数字
     */
    private static void isDivisibleBy357(int val) {
        if ((val % 3 == 0) && (val % 5 == 0) && (val % 7 == 0)){
            System.out.println(String.format("val：%s，可以被3、5、7同时整除", val));
        }else {
            System.out.println(String.format("val：%s，不能被3、5、7同时整除", val));
        }
    }

    /**
     * 给定三个数，求出这3个数字中的最大值，并将最大值输出
     */
    private static void printMaxVal(int val1, int val2, int val3) {

        // 存储最大值
        int maxVal;

        // 判断最大的那个值
        maxVal = (val1 > val2)? val1 : val2;
        maxVal = (maxVal > val3)? maxVal : val3;

        System.out.println(String.format("%s、%s、%s中的最大值为：%s", val1, val2, val3, maxVal));
    }

    /**
     * 两数交换
     */
    private static void twoDigitExchange(int val1, int val2) {
        if (val1 < 0 || val2 < 0){
            System.out.println("请输入一个整数");
            return;
        }

        System.out.println(String.format("交换前：val1：%s，val2：%s", val1, val2));

        // 交换数字
        int temp;
        temp = val1;
        val1 = val2;
        val2 = temp;

        System.out.println(String.format("交换后：val1：%s，val2：%s", val1, val2));

    }

    /**
     * 打印出1~10000范围中所有的“水仙花数”
     */
    private static void printNarcissisticNumber() {
        System.out.print("1~10000范围中所有的“水仙花数：");
        for (int n = 0; n < 10000; n++) {
            if (isNarcissisticNumber(n)){
                System.out.print(n +"、");
            }
        }
        // 循环结束换行
        System.out.println();
    }

    /**
     * 判断一个数是否为水仙花数
     * 水仙花数（Narcissistic Number），也称为自恋数或阿姆斯壮数，是指一个 n 位数（n ≥ 3），它的每个位上的数字的 n 次幂之和等于它本身。
     * @param num 传入的数字
     */
    private static boolean isNarcissisticNumber(int num) {
        int sum = 0;
        int temp = num;
        int length = String.valueOf(num).length();

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, length);
            temp /= 10;
        }

        return sum == num;
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
