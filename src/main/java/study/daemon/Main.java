package study.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class Main {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<Event>();
        WriterTask writer = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
