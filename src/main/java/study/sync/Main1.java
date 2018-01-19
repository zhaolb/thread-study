package study.sync;

/**
 * Created by zhaolb on 2018/1/12.
 */
public class Main1 {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(ticketOffice1,"TicketOffice1");

        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(ticketOffice2,"TicketOffice2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room1 Vacancies: %d\n",cinema.getVacanciesCinema1());
        System.out.printf("Room2 Vacancies: %d\n",cinema.getVacanciesCinema2());
    }
}
