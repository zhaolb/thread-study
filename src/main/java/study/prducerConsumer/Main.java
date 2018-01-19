package study.prducerConsumer;

/**
 * Created by zhaolb on 2018/1/19.
 */
public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread t1 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
