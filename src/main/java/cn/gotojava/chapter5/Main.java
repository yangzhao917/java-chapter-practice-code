package cn.gotojava.chapter5;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description：第五章：面向对象编程（基础篇）
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class Main {

    /*
    本章要点：
    1.面向对象的三大特征：封装、继承、多态。
    2.类与对象的关系：类是对象的模板，对象是类的实例，类只能通过对象才可以使用。
    3.类是由属性和方法组成。
    4.对象的产生格式：类名称 对象名称 = new 类名称()。
    5.如果一个对象没有被实例化而直接使用，则使用时会出现空指向异常。
    6.类属于引用数据类型，进行引用传递时，传递的是堆内存的使用权。
    7.类的封装性：通过private关键字进行修饰，被封装的属性不能被外部直接调用，而只能通过setter或getter方法完成。
        只要是属性，则必须全部封装。
    8.构造方法可以为类中的属性初始化，构造方法与类名称相同，无返回值类型声明，如果在类中没有明确的定义出构造方法，
        则会自动生成一个无参的什么都不做的构造方法，在一个类中的构造方法可以重载，但是每个类都至少有一个构造方法。
    9.String类在Java中较为特殊，String可以使用直接赋值的方式，也可以通过构造方法进行实例化，前者只产生一个实例化对象，
        而且此实例化对象可以重用，后者将产生两个实例化对象，其中一个是垃圾空间，在String中比较内容使用equals方法，而"=="
        比较的只是两个字符串的地址值。字符串的内容一旦声明则不可改变。
    10.在Java中使用this关键字可以表示当前的对象，通过this属性可以调用本类中的属性，通过this.方法()可以调用本类中的其他方法，
        也可以通过this()的形式调用本类中的构造方法，但是调用时要求要放在构造方法的首行。
    11.使用static声明的属性和方法可以由类名称直接调用，static属性是所有对象共享的，所有对象都可以对其进行操作。
    12.如果需要限制类对象的产生，则可以将构造方法私有化。
    13.对象数组的使用要分成声明数组，为数组开辟空间两个部分。开辟空间之后数组中的每个元素的内容都是null。
    14.内部类是在一个类的内部定义另外的一个类，使用内部类可以方便地访问外部类的私有操作。
        在方法中声明的内部类想要访问方法的参数，则参数前必须加上final关键字，而从JDK1.8之后此限制取消。
     */

    public static void main(String[] args) {
        //编写并测试一个代表地址的Address类，地址信息由国家、省份、城市、街道、邮编组成，并可以返回完整的地址信息。
        Address address = new Address("中国", "上海", "上海市", "闵浦一居委", "201109");
        System.out.println(address.print());

        //定义并测试一个代表员工的Employee类。员工属性包括"编号"、"姓名"、"基本薪水"和"薪水增长额"，还包括计算薪水增长额及计算增长后的工资总额的操作方法
        Employee employee = new Employee(100L, "张三", 10000, 5);
        System.out.println(String.format("员工信息：%s，薪水总额：%s，薪水增长额：%s", employee.print(), employee.calculateTotalSalary(), employee.calculateSalaryIncrease()));

        countOccurrences();

        //设计一个Dog类，有名字、颜色、年龄等属性，定义构造方法来初始化类的这些属性，定义方法输出Dog信息，编写应用程序使用Dog类
        Dog dog = new Dog("丁奇", "蓝色", 3);
        System.out.println(dog.print());

        /*
        设计一个表示用户的User类，类中的变量有用户名、口令和记录用户个数的变量，定义类的3个构造方法（无参、为用户名赋值、为用户名和口令赋值）、
        获取和设置口令的方法和返回类信息的方法。
         */
        User user = new User("zhangsan", "zhangsan");
        System.out.println(user.print());
        //修改密码
        user.setPassword("123456");
        System.out.println(user.print());

        stringOperation();

        Account account = new Account("张三", 4);
        account.getBalance();

        // 声明一个图书类，其数据成员为书名、编号（利用静态变量实现自动编号）、书价，并拥有静态数据成员册数、记录图书的总册数，在构造方法中利用此静态变量为对象的编号赋值，在主方法中定义对象数组，并求出总册数。
        // 定义对象数组
        Books books[] = new Books[5];
        books[0] = new Books("《毛泽东思想》", 100);
        books[1] = new Books("《邓小平理论》", 100);
        books[2] = new Books("《Java核心编程卷一》", 100);
        books[3] = new Books("《钢铁是怎么练成的》", 100);
        books[4] = new Books("《战国策》", 100);
        for (Books book : books) {
            System.out.println(book);
        }
        System.out.println(String.format("总册数：%s", Books.getTotalBooks()));
    }

    /**
     * 字符串操作
     */
    private static void stringOperation() {
        // 从字符串"Java技术学习班20070326"中提取开班日期
        String source = "Java 技术学习班Java20070326 MLDN老师";
        String subNew = source.substring(9);
        System.out.println(String.format("源字符串：%s，提取字符串：%s", source, subNew));

        // 将"MLDN Java"字符串中的"Java"替换为"J2EE"
        String origin = "MLDN Java";
        String replace = origin.replace("Java", "J2EEE");
        System.out.println(String.format("源字符串：%s，替换字符串：%s", origin, replace));

        //取出"Java技术学习班20070326"中的第8个字符
        System.out.println(String.format("源字符串：%s，第八个字符为：%s", source, source.charAt(8)));

        //清除"Java技术学习班20070326"中的所有0
        System.out.println(String.format("源字符串：%s，替换后的字符串：%s", source, source.replace("0", "")));

        //清除"Java 技术学习班20070326 MLDN老师"中的所有空格
        System.out.println(String.format("源字符串：%s，替换后的字符串：%s", source, source.replaceAll("\\s", "")));

        extractBirthdateFromId();
    }

    /**
     * 从任意给定的身份证号码中提取此人的出生日期
     */
    private static void extractBirthdateFromId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入身份证号：");
        String inputId = scanner.next();
        if (inputId.length() < 18) {
            extractBirthdateFromId();
        } else {
            String userId = extractBirthdate(inputId);
            if (Objects.isNull(userId)) {
                System.out.println("身份证号码格式错误");
                return;
            }
            System.out.println(String.format("身份证号：%s，出生日期：%s", inputId, userId));
        }
    }

    /**
     * 获取身份证号
     *
     * @param userId 身份证号码
     * @return 匹配成功返回出生日期，匹配失败返回-1
     */
    private static String extractBirthdate(String userId) {
        String regex = "(\\d{6})(\\d{8})(\\d{4})[\\d{3}Xx]?";
        Matcher matcher = Pattern.compile(regex).matcher(userId);
        if (matcher.matches()) {
            return matcher.group(2);
        }
        return null;
    }

    /**
     * 统计出字符串"want you to know one thing"中字母n和字母o的出现次数。
     */
    private static void countOccurrences() {
        String searchStr = "want you to know one thing";
        // 统计字符n
        countOccurrencesByKey(searchStr, 'c');
        // 统计字符o
        countOccurrencesByKey(searchStr, 'g');
    }

    /**
     * 统计字符n的在指定字符串中出现的次数
     *
     * @param val 搜索的字符串
     * @param reg 查找的字符
     */
    private static void countOccurrencesByKey(String val, char reg) {
        int count = countOccurrences(val, reg);
        System.out.println(String.format("字符%s在字符串{%s}的次数是：%s", reg, val, count));
    }

    /**
     * 统计字符在指定字符串中的次数
     *
     * @param val 搜索的字符串
     * @param reg 查找的字符
     * @return 在指定字符串中出现的次数
     */
    private static int countOccurrences(String val, char reg) {
        if (val.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == reg) {
                count++;
            }
        }
        return count;
    }

}
