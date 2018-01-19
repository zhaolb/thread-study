package study.exception;

import java.util.Random;

/**
 * Created by zhaolb on 2018/1/11.
 */
public class Task1 implements Runnable  {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true){
            result = 1000/(int)(random.nextDouble() * 1000);
            System.out.printf("%s : %d\n",Thread.currentThread().getId(),result);
            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d:interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }
}
