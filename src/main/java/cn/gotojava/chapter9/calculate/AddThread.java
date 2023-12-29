package cn.gotojava.chapter9.calculate;

public class AddThread implements Runnable {

    private Resource resource;

    public AddThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.resource.add();
        }
    }

}
