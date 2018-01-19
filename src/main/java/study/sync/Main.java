package study.sync;

/**
 * Created by zhaolb on 2018/1/12.
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("account: initial balance: %f\n",account.getBalance());
        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("account: final balance : %f\n",account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
