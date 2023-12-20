package cn.gotojava.chapter1;

/**
 * description：第一章：认识Java章节练习
 *
 * @author yangzhao
 * @createBy 2023/12/20
 */
public class Practice {

    /*
    本章要点：
        1.Java实现可移植性靠的是JVM，JVM就是一台虚拟的计算机，只要在不同的操作系统上植入不同版本的JVM，那么Java程序就可以在各个平台上移植，做到"一次编写，处处运行"。
        2.Java中程序的执行步骤为：】
        ①：使用javac将一个*.java文件编译成*.class文件。
        ②：使用Java可以执行一个*.class文件。
        3.每次使用Java命令执行一个class的时候，都会启动JVM，JVM通过classpath给出的路径加载所需要的类文件，可以通过set classpath设置类的加载路径。
        4.Java程序主要分为Java Application和Java Applet程序两种，Java Applet主要是在网页中嵌入的Java程序，基本上已经不再使用了；
        而Application是指有main()方法的程序，本书主要讲解Application。
     */

    public static void main(String[] args) {
        printOut();

        printGraph();
    }

    /**
     * 在屏上打印出以下的图形
     */
    private static void printGraph() {
        System.out.println("************************");
        System.out.println("****   Java程序设计   ****");
        System.out.println("************************");
    }

    /**
     * 在屏幕上输出"我喜欢学习Java"的信息
     */
    private static void printOut() {
        System.out.println("我喜欢学习Java");
    }



}
