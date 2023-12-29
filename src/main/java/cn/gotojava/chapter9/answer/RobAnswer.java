package cn.gotojava.chapter9.answer;

import java.util.concurrent.Callable;

/**
 * 抢答线程类
 */
public class RobAnswer implements Callable<String> {

    // 抢答处理，默认为失败，成功则为true
    private boolean flag = false;

    @Override
    public String call() throws Exception {
        synchronized (this){
            if (!flag){
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功";
            }
        }
        return Thread.currentThread().getName() + "抢答失败";
    }
}
