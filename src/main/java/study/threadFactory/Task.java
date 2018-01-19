package study.threadFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/11.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
