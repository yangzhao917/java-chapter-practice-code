package cn.gotojava.chapter11;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 十一章：Java常用类库
 */
public class Main {

    /*
    本章要点：
    1.在一个字符串内容需要频繁修改时，使用StringBuffer可以提升操作性能，因为StringBuffer的内容是可以改变的，而String的内容不可以改变。
    2.StringBuffer类中提供了增加、替换、插入等大量的字符串操作方法。
    3.Runtime表示运行时，在一个JVM中只存在一个Runtime，所以要想取得Runtime类的对象，直接使用Runtime类中提供的静态方法getRuntime()即可。
    4.国际化程序实现的基本原理为：所有的语言信息以key->value的形式保存在资源文件中，程序通过key找到相应的value，根据其所设置的国家的Locale
        对象不通，找到的资源文件也不同。要想实现国际化必须依靠Locale、ResourceBundle两个类共同完成。
    5.System类是系统类，可以取得系统的相关信息，使用System.gc()方法可以强制性进行垃圾的收集操作，调用此方法实际上就是调用了Runtime类中的gc()
        方法。
    6.Format类为格式化操作类，主要的3个子类是MessageFormat、NumberFormat、DateFormat。
    7.使用Date类可以方便地取得时间，但取得的时间格式不符合地域的习惯，所以可以使用SimpleDateFormat类进行日期的格式化操作。
    8.处理大数字可以使用BigInteger、BigDecimal，当需要精确小数点操作位数时使用BigDecimal类即可。
    9.通过Random类可以取得指定范围的随机数字。
    10.如果一个类的对象要想被克隆，则次对象所在的类必须实现Cloneable接口。
    11.要想对一组对象进行排序，则必须使用比较器，比较器接口Comparable中定义了一个compareTo()的比较方法，用来设置比较规则。
    12.正则表达式是在开发中最常使用的一种验证方法，String类中的replaceAll()、split()、matches()方法都对正则有所支持。
    13.可以使用Time和TimeTask类完成系统的定时操作。
     */

    public static void main(String[] args) {

        // 1.定义一个StringBuffer类对象，然后通过append()方法向对象中添加26个小写字母，要求每次只添加一个，共添加26次，然后按照逆序的方式输出，并且可以删除前5个字符。
        appendLetter();

        // 2.使用Random类产生5个1~30之间（包括1和30）的随机整数。
        randomGenerate();

        // 3.输入一个E-Mail地址，然后使用正则表达式验证该E-Mail地址是否正确。
        validEMail();

        // 4.编写程序，用0~1之前的随机数来模拟掷硬币实验，统计掷1000次后出现正、反面的次数并输出。
        randomCoin();

        // 5.编写正则表达式，判断给定的是否为一个合法的IP地址。
        validIPAddress();

        /*
        6.给定下面的HTML代码：<font face="Arial,Serif" size="+2" color="red">要求对内容进行拆分，拆分之后的结果是：
        face Arial,Serif，
        size +2，
        color red
         */
        splitHtml();

        // 7.编写程序，实现国际化应用，从命令行输入国家的代号，例如1表示中国，2表示美国，然后根据输入代号的不同调用不同的资源文件显示信息。
        System.out.println("国家代号：\n1：中国；\n2：美国\n3：日本\n");
        selectInternationLanguage();

        /*
        8. 按照"姓名：年龄：成绩|姓名：年龄：成绩"的格式定义字符串"张三:21:98|李四:22:89|王五:20:70"，要求将每组值分别保存在Student对象之中，
            并对这些对象进行排序，排序的原则为：按照成绩由高到低排序，如果成绩相等，则按照年龄由低到高排序。
         */
        parseStudent();
    }

    private static void parseStudent() {
        String content = "张三:21:70|李四:22:100|王五:50:70";

        String[] result = content.split("\\|");
        // 存储学生集合
        Student[] students = new Student[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] split = result[i].split(":");
            students[i] = new Student(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]));
        }
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

    /**
     * 拆分HTML
     */
    private static void splitHtml() {
        String html = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";
        String regex = "\\w+=\"[a-zA-Z0-9+,]+\"";
        Matcher matcher = Pattern.compile(regex).matcher(html);
        while (matcher.find()) {
            String temp = matcher.group(0);
            String[] result = temp.split("=");
            System.out.printf("%s\t%s%n", result[0], result[1].replace("\"", ""));
        }
    }

    /**
     * 7.编写程序，实现国际化应用，从命令行输入国家的代号，例如1表示中国，2表示美国，然后根据输入代号的不同调用不同的资源文件显示信息。
     */
    private static void selectInternationLanguage() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print("请输入指令代号：");
        Scanner scanner = new Scanner(System.in);
        try {
            String inputValue = scanner.next();
            // 获取资源内容
            String message = new MessageUtil().getMessage(Integer.parseInt(inputValue));
            // 格式化
            String info = MessageFormat.format(message, dateFormat.format(new Date()));
            System.out.println(info);
        } catch (Exception ex) {
            System.out.println("系统异常!");
        }
    }

    /**
     * 4.编写程序，用0~1之前的随机数来模拟掷硬币实验，统计掷1000次后出现正、反面的次数并输出。
     */
    private static void randomCoin() {
        // 记录正面次数
        int headsCount = 0;
        int tailsCount = 0;

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            double result = random.nextDouble();
            // 随机数大于0.5为正面，否则为反面
            if (result > 0.5) {
                headsCount++;
            } else {
                tailsCount++;
            }
        }

        System.out.printf("正面次数：%s%n", headsCount);
        System.out.printf("反面次数：%s%n", tailsCount);
    }

    private static void validIPAddress() {
        String ipAddress = "192.168.0.1";
        if (isValidIPAddress(ipAddress)) {
            System.out.printf("%s 是一个合法的IP地址%n", ipAddress);
        } else {
            System.out.printf("%s 不是一个合法的IP地址%n", ipAddress);
        }
    }

    /**
     * 验证是不是一个IP地址
     *
     * @param ipAddress 要验证的IP地址
     */
    private static boolean isValidIPAddress(String ipAddress) {
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$";
        return Pattern.compile(ipv4Regex).matcher(ipAddress).matches();
    }

    /**
     * 3.输入一个E-Mail地址，然后使用正则表达式验证该E-Mail地址是否正确。
     */
    private static void validEMail() {
        // 获取输入的Email地址
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个E-Mail地址：");
        String inputEmail = scanner.next();
        if (isValidEmail(inputEmail)) {
            System.out.printf("%s 合法的EMail地址%n", inputEmail);
        } else {
            System.out.printf("%s 不合法的EMail地址%n", inputEmail);
        }
    }

    /**
     * 验证是否是一个合法的Email地址
     *
     * @param email 要验证的Email地址
     */
    private static boolean isValidEmail(String email) {
        // 定义E-Mail地址的正则表达式
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // 验证是否合法
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    /**
     * 2.使用Random类产生5个1~30之间（包括1和30）的随机整数。
     */
    private static void randomGenerate() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextInt(30) + "、");
        }
    }

    /**
     * 1.定义一个StringBuffer类对象，然后通过append()方法向对象中添加26个小写字母，要求每次只添加一个，共添加26次，然后按照逆序的方式输出，
     * 并且可以删除前5个字符。
     */
    private static void appendLetter() {
        // 定义26个小写字母数组
        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"};

        // 添加26个小写字母
        StringBuilder buffer = new StringBuilder();
        for (String s : array) {
            buffer.append(s);
        }
        // 逆序输出，并且删除前五个字符
        StringBuilder delete = buffer.reverse().delete(0, 5);
        System.out.println(delete);
    }
}
