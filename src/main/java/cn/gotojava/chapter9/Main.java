package cn.gotojava.chapter9;

import cn.gotojava.chapter9.answer.RobAnswer;
import cn.gotojava.chapter9.calculate.AddThread;
import cn.gotojava.chapter9.calculate.Resource;
import cn.gotojava.chapter9.calculate.SubThread;
import cn.gotojava.chapter9.computer.ComputerResource;
import cn.gotojava.chapter9.computer.Consumer;
import cn.gotojava.chapter9.computer.Producer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * description：第九章：多线程
 *
 * @author yangzhao
 * @createBy 2023/12/25
 */
public class Main {

    /*
    本章要点：
    1.线程（Thread）是指程序的运行流程。"多线程"的机制可以同时运行多个程序块，使程序运行的效率更高，也解决了传统程序设计语言所无法解决的问题。
    2.如果在类里要激活线程，必须先做好下面两项准备：
        1）此类必须是扩展自Thread类，使自己成为它的子类。
        2）线程的处理必须编写在run()方法内。
    3.run()方法是定义在Thread类里的一个方法，因此把线程的程序代码编写在run()方法内，所做的就是覆写操作。
    4.Runnable接口里声明了抽象的run()方法，因此必须在实现Runnable接口的类里明确定义run()方法。
    5.Callable接口是JDK1.5之后添加的新的线程接口。利用此接口可以在线程操作执行完毕返回相应的结果。
    6.每一个线程，在其创建和消亡之前，均会处于创建、就绪、运行、阻塞、终止5种状态之一。
    7.暂停状态的线程可由下列情况产生：
        1).该线程调用对象的wait()时。
        2).该线程本身调用sleep()时。
        3).该线程和另一个线程join()在一起时。
    8.被冻结因素消失的原因有：
        1).如果线程是由调用对象的wait()方法所冻结，则该对象的notify()方法被调用时可解除冻结。
        2).线程进入休眠（sleep）状态，但指定的休眠时间到了。
    9.当线程的run()方法运行结束，或是由线程调用它的stop()方法时，则线程进入消亡状态。
    10.Thread类里的sleep()方法可以用来控制线程的休眠状态，休眠的时间要视sleep()里的参数而定。
    11.要强制某一线程运行，可用join()方法。
    12.join()方法会抛出InterruptedException的异常，所以编程时必须把join()方法编写在try...catch块内。
    13.当多个线程对象操纵同一共享资源时，要使用synchronized关键字进行资源的同步处理。
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 设计4个线程对象，两个线程执行减操作，两个线程执行加操作。
        Resource resource = new Resource();
        new Thread(new AddThread(resource), "加法线程-A").start();
        new Thread(new SubThread(resource), "减法线程-X").start();
        new Thread(new AddThread(resource), "加法线程-B").start();
        new Thread(new SubThread(resource), "减法线程-Y").start();

        /*
        设计一个生产计算机和搬运计算机类，要求生产出一台电脑就搬走一台，如果没有新的计算机生产出来，则搬运工要等待新计算机产出；
        如果生产出的计算机没有搬走，则要等待计算机搬走之后再生产，并统计出生产的计算机数量。
         */
        ComputerResource computerResource = new ComputerResource();
        new Thread(new Producer(computerResource), "电脑生产者").start();
        new Thread(new Consumer(computerResource), "取走计算机").start();


        // 实现一个竞拍抢答程序：要求设置3个抢答者（三个线程），而后同时发出抢答指令，并为抢答成功者给出成功提示，为未抢答成功者给出失败提示
        RobAnswer robAnswer = new RobAnswer();
        FutureTask<String> taskA = new FutureTask<>(robAnswer);
        FutureTask<String> taskB = new FutureTask<>(robAnswer);
        FutureTask<String> taskC = new FutureTask<>(robAnswer);
        new Thread(taskA, "抢答者-A").start();
        new Thread(taskB, "抢答者-B").start();
        new Thread(taskC, "抢答者-C").start();
        System.out.println(String.format("竞赛结果：%s", taskA.get()));
        System.out.println(String.format("竞赛结果：%s", taskB.get()));
        System.out.println(String.format("竞赛结果：%s", taskC.get()));
    }
}