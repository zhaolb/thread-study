package study.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class Main {
    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(task);
            t.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
