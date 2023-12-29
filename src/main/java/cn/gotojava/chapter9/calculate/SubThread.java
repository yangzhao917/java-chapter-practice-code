package cn.gotojava.chapter9.calculate;

public class SubThread implements Runnable {

    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
             this.resource.sub();
        }
    }

}
