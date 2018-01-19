package study.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaolb on 2018/1/19.
 */
public class Main {
    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(10000);
        Task task = new Task(products, 0, products.size(), 0.2);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task); //异步调用.pool.invoke()是同步调用

        do {
            System.out.printf("Main:Thread Count: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main:Thread Steal: %d\n",pool.getStealCount());
            System.out.printf("Main:Parallelism: %d\n",pool.getParallelism());

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        if(task.isCompletedNormally()){
            System.out.printf("Main: the process has completed normally.\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getPrice() != 12){
                System.out.printf("Product %s : %f\n",product.getName(),product.getPrice());
            }
        }

        System.out.printf("Main: end of the program.\n");
    }
}
