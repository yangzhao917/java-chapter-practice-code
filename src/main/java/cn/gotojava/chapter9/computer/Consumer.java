package cn.gotojava.chapter9.computer;

/**
 * 计算机消费线程
 */
public class Consumer implements Runnable {

    private ComputerResource resource;


    public Consumer(ComputerResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.resource.move();
        }
    }

}
