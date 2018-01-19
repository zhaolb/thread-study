package study.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/19.
 */
public class Main1 {
    public static void main(String[] args) {
        Document document = new Document();
        String[][] doc = document.generateDocument(100,1000,"the");

        DocumentTask task = new DocumentTask(doc,0,100,"the");
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do {
            System.out.println("************************************");
            System.out.printf("Main: parallelism: %d\n",pool.getParallelism());
            System.out.printf("Main: active threads: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: task count: %d\n",pool.getQueuedTaskCount());
            System.out.printf("Main: steal count: %d\n",pool.getStealCount());
            System.out.println("************************************");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!task.isDone());

        pool.shutdown();

        try {
            pool.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Main: the word appears %d in the document",task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
