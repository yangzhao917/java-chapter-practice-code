package cn.gotojava.chapter9.calculate;

public class Resource {

    private int num = 0;

    // 加减的切换，true表示可以进行加法操作，不能进行减法操作；false表示可以进行减法操作，不能进行加法操作
    private volatile boolean  flag = true;

    /**
     * 加法操作
     */
    public synchronized void add() {
        if (!flag){
            // 执行减法操作，加法线程需等待
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            // 模拟延迟操作
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.num++;
        System.out.println(String.format("[加法操作] ThreadName:%s，num：%s", Thread.currentThread().getName(), this.num));

        // 加法操作执行完了，现在执行减法操作
        this.flag = false;
        super.notify();
    }

    public synchronized void sub(){
        if (flag){
            // 执行加法操作，减法线程需等待
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            // 模拟延迟操作
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.num--;
        System.err.println(String.format("[减法操作] ThreadName:%s，num：%s", Thread.currentThread().getName(), this.num));

        // 减法操作执行完了，执行加法线程
        this.flag = true;
        super.notify();
    }
}