package study.sync;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhaolb on 2018/1/12.
 */
@Setter
@Getter
public class Account {
    private double balance;

    public synchronized void addAmount(double amount) {
        double tmp = balance;
        System.out.println("1111");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("222");
        tmp += amount;
        balance = tmp;
    }

    public synchronized void subtractAmount(double amount) {
        double tmp = balance;
        System.out.println("333");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("444");
        tmp -= amount;
        balance = tmp;
    }
}
