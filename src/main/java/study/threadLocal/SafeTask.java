package study.threadLocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class SafeTask implements Runnable {
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("starting thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("thread finished: %s:%s\n",Thread.currentThread().getId(),startDate.get());
    }
}
