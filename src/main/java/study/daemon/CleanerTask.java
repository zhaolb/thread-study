package study.daemon;

import java.util.Date;
import java.util.Deque;

/**
 * Created by zhaolb on 2018/1/10.
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long diff;
        boolean delete;
        if (deque.size() == 0) {
            return;
        }
        delete = false;
        do {
            Event e = deque.getLast();
            diff = date.getTime() - e.getDate().getTime();
            if (diff > 10000) {
                System.out.printf("Cleaner:%s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (diff > 10000);
        if(delete){
            System.out.printf("Cleaner: size of the deque:%d\n",deque.size());
        }
    }
}
