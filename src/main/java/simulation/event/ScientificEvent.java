package simulation.event;

import simulation.student.StatisticType;
import simulation.student.Student;
import simulation.subject.Subject;

/**
 * Klasa simulation.event.ScientificEvent reprezentuje wydarzenie podczas zajec z okreslonego kursu.
 * Sprawdza wybrany typ statystyki, jezeli bedzie spelniala wymog to dodaje ocene pozytywna,
 * a jesli nie to dodaje ocene negatywna do przedmiotu.
 */

public class ScientificEvent implements Event {

    String description;
    StatisticType typeOfStatistic;
    int requiredStatistic;
    /**
     * Stworzenie instancji simulation.event.ScientificEvent
     *
     * @param description     opis wydarzenia
     * @param typeOfStatistic typ sprawdzanej statystyki
     * @param requirements    wymagana wartosc statystyki
     */
    public ScientificEvent(String description, StatisticType typeOfStatistic, int requirements ){
        this.description=description;
        this.typeOfStatistic=typeOfStatistic;
        this.requiredStatistic=requirements;
    }

    /**
     * Metoda sprawdza czy simulation.student spełnia wymogi wydarzenia
     * @param student na którym ma zostać dokonane sprawdzenie.
     */
    @Override
    public void apply(Student student)
    {
        System.out.println(description);
        int statDifference = student.getStatistic(typeOfStatistic) - requiredStatistic;
        if(statDifference >= 0) {
            int markToAdd = 3;
            if(statDifference >= requiredStatistic)
                markToAdd = 5;
            else if((float)statDifference >= (float)requiredStatistic * .5f)
                markToAdd = 4;

            System.out.println("Udało się, otrzymałeś ocene: " + markToAdd);
        }
        else
        {
            System.out.println("Nie udało się, otrzymałeś ocene: 2");
        }
    }
}
