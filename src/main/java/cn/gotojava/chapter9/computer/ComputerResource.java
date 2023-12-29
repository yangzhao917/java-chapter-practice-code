package cn.gotojava.chapter9.computer;

import java.util.Objects;

/**
 * 电脑资源类
 */
public class ComputerResource {

    // 存储生产的计算机
    private Computer computer;

    /**
     * 生产计算机
     */
    public synchronized void producer(){
        // 已经生产好了，可以搬运
        if (Objects.nonNull(computer)){
            try {
                // 生产线程等待
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 生产电脑
        this.computer = new Computer("联想电脑", 5000);
        System.out.println(String.format("【%s】%s", Thread.currentThread().getName(), computer));
        super.notify();
    }

    /**
     * 搬运计算机
     */
    public synchronized void move(){
        // 没有生产过，等待生产
        if (Objects.isNull(computer)){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("【%s】%s", Thread.currentThread().getName(), this.computer));

        this.computer = null;
        super.notify();
    }
}
