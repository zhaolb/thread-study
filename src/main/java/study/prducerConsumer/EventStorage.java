package study.prducerConsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaolb on 2018/1/12.
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<Date>();
    }

    /**
     * 当一个线程调用wait()方法时,JVM将这个线程置入休眠,并且释放控制这个同步代码块的对象，
     * 同时允许其它线程执行这个对象控制的其他同步代码块。为了唤醒这个线程，必须在这个对象
     * 控制的某个同步代码块中调用notify()或者notifyAll()方法
     */

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.printf("Set: %d",storage.size());
        notifyAll();
    }

    public synchronized void get(){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d:%s",storage.size(),((LinkedList<?>)storage).poll());
    }
}
