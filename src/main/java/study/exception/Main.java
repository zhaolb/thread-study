package study.exception;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class Main {
    public static void main(String[] args) {
        Task t = new Task();
        Thread thread = new Thread(t);
        //thread.setUncaughtExceptionHandler(new ExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
