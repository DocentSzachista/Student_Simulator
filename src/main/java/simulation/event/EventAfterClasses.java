package simulation.event;

import simulation.student.StatisticChange;
import simulation.student.StatisticType;
import simulation.student.Student;

import java.util.Random;

/**
 * Klasa simulation.event.EventAfterClasses sprawdza wydarzenie po zajęciach
 * Jeżeli simulation.student spełni wymagania to otrzyma tymczasowy boost do danej statystyki, w innym wypadku otrzyma ujemny.
 */

public class EventAfterClasses implements Event {
    String description;
    StatisticType typeOfStatistic;
    int requiredStatistic;
    /**
     * Stworzenie nowego wydarzenia po zajęciach
     * @param description opis wydarzenia
     * @param typeOfStatistic typ statystyki jaką wydarzenie sprawdza
     * @param requiredStatistic wymagana ilość statystyki
     */
    public EventAfterClasses(String description, StatisticType typeOfStatistic, int requiredStatistic) {
        this.description=description;
        this.typeOfStatistic=typeOfStatistic;
        this.requiredStatistic=requiredStatistic;
    }

    /**
     *
     * @param student pobieranie informacji o statystyce studenta i porównywanie jej z ze statystyką wydarzenia
     * Stworzenie nowego bonusu do statystyk
     */
    @Override
    public void apply(Student student) {
        Random random= new Random();
        int boost= random.nextInt(3)+2;
        int days= random.nextInt(3)+1;
        StatisticChange zmiana;
        System.out.println(description);
        if (student.getStatistic(typeOfStatistic)>requiredStatistic) {
            zmiana = new StatisticChange(typeOfStatistic, boost, days);
            System.out.println("Udało się, Twoja/Twój " + typeOfStatistic + " zwiększyła się o " + boost + " pkt na " + days + " dni/dzień");
        } else {
            zmiana = new StatisticChange(typeOfStatistic, -boost, days);
            System.out.println("Nie udało się, Twoja/Twój " + typeOfStatistic + " zmniejszyła się o " + boost + " pkt na " + days + " dni/dzień");
        }
        student.addStatisticChange(zmiana);
    }
}
