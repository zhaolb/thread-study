package study.exception;

/**
 * Created by zhaolb on 2018/1/11.
 */
public class Main1 {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task1 task = new Task1();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(threadGroup,task);
            t.start();
        }
    }
}
