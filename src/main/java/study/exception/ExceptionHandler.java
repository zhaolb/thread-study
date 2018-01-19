package study.exception;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("an exception has been captured\n");
        System.out.printf("thread:%s\n",t.getId());
        System.out.printf("exception: %s:%s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("stack trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("thread status:%s\n",t.getState());
    }
}
