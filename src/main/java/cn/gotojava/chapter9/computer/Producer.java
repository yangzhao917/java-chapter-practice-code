package cn.gotojava.chapter9.computer;

/**
 * 计算机生产者线程
 */
public class Producer implements Runnable{

    private ComputerResource resource;

    public Producer(ComputerResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.resource.producer();
        }
    }
}
