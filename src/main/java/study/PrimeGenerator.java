package study;

/**
 * Created by zhaolb on 2018/1/9.
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.println("Number is prime: "+number);
            }
            if (isInterrupted()) {
                System.out.println("the prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        task.interrupt();

        System.out.println("main thread is over");
    }
}
