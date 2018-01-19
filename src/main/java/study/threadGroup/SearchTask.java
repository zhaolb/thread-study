package study.threadGroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class SearchTask implements Runnable {
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("thread %s: start\n", name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("thread %s:interrupted\n", name);
            return;
        }
        System.out.printf("thread %s:end\n", name);
    }

    private void doTask() throws InterruptedException {
        Random r = new Random(new Date().getTime());
        int value = (int) (r.nextDouble() * 100);
        System.out.printf("thread:%s: %d\n",Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }
}
