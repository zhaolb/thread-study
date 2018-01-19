package study.threadGroup;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("searcher");
        Result result = new Result();
        SearchTask task = new SearchTask(result);

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(threadGroup,task);
            t.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("number of threads: %d\n",threadGroup.activeCount());
        System.out.printf("information about the thread group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("thread %s:%s\n",threads[i].getName(),threads[i].getState());
        }
        
        waitFinish(threadGroup);

        threadGroup.interrupt();
    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
