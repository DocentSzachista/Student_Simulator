package simulation.event;

import simulation.student.StatisticChange;
import simulation.student.StatisticType;
import simulation.student.Student;
import simulation.subject.Subject;

import java.util.Random;

/**
 * Klasa simulation.event.EventAfterClasses sprawdza wydarzenie po zajęciach
 * Jeżeli simulation.student spełni wymagania to otrzyma tymczasowy boost do danej statystyki, w innym wypadku otrzyma ujemny.
 */

public class WeekendEvent implements Event {
    String description;
    StatisticType typeOfStatistic;
    int requiredStatistic;
    /**
     * Stworzenie nowego wydarzenia po zajęciach
     * @param description opis wydarzenia
     * @param typeOfStatistic typ statystyki jaką wydarzenie sprawdza
     * @param requiredStatistic wymagana ilość statystyki
     */
    public WeekendEvent (String description, StatisticType typeOfStatistic, int requiredStatistic) {
        this.description=description;
        this.typeOfStatistic=typeOfStatistic;
        this.requiredStatistic=requiredStatistic;
    }

    /**
     * Metoda tworząca nowy bonus do statystyk
     * @param student pobieranie informacji o statystyce studenta i porównywanie jej z ze statystyką wydarzenia
     *
     */
    @Override
    public void apply(Student student, Subject subject) {
        Random random= new Random();
        int boost= random.nextInt(3)+2;
        int days= random.nextInt(3)+1;
        StatisticChange change;
        System.out.println(description);
        if (student.getStatistic(typeOfStatistic)>requiredStatistic)
        {
            change = new StatisticChange(typeOfStatistic, boost, days);
            System.out.println("Udało się, Twoja/Twój " + typeOfStatistic + " zwiększyła się o " + boost + " pkt na " + days + " dni/dzień");
        }
        else
        {
            change = new StatisticChange(typeOfStatistic, -boost, days);
            System.out.println("Nie udało się, Twoja/Twój " + typeOfStatistic + " zmniejszyła się o " + boost + " pkt na " + days + " dni/dzień");
        }
        student.addStatisticChange(change);
    }
}
