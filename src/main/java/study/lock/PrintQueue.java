package study.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaolb on 2018/1/19.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document){
        queueLock.lock();

        long duration = (long)(Math.random() * 10000);
        System.out.println(Thread.currentThread().getName() + ":PrintQueue: printing a job during " + (duration /1000)+ " seconds");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }

}
