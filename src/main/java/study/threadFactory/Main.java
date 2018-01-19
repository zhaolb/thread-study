package study.threadFactory;

/**
 * Created by zhaolb on 2018/1/11.
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread thread;
        System.out.printf("starting the threads\n");
        for (int i = 0; i < 10; i++) {
            thread = threadFactory.newThread(task);
            thread.start();
        }

        System.out.printf("factory stats;\n");
        System.out.printf("%s\n",threadFactory.getStats());
    }
}
