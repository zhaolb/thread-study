package study;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class FileClock implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has bean interrupted");
            }
        }
    }

    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread t = new Thread(clock);
        t.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
    }
}
