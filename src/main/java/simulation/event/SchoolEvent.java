package simulation.event;

import simulation.student.StatisticType;
import simulation.student.Student;
import simulation.subject.Subject;

/**
 * Klasa simulation.event.ScientificEvent reprezentuje wydarzenie podczas zajec z okreslonego kursu.
 * Sprawdza wybrany typ statystyki, jezeli bedzie spelniala wymog to dodaje ocene pozytywna,
 * a jesli nie to dodaje ocene negatywna do przedmiotu.
 */

public class SchoolEvent implements Event
{
    private final String description;
    private final StatisticType typeOfStatistic;
    private final int requiredStatistic;

    /**
     * Stworzenie instancji simulation.event.ScientificEvent
     *
     * @param description     opis wydarzenia
     * @param typeOfStatistic typ sprawdzanej statystyki
     * @param requirements    wymagana wartosc statystyki
     */
    public SchoolEvent(String description, StatisticType typeOfStatistic, int requirements)
    {
        this.description = description;
        this.typeOfStatistic = typeOfStatistic;
        this.requiredStatistic = requirements;
    }

    /**
     * Metoda sprawdza czy simulation.student spełnia wymogi wydarzenia
     *
     * @param student na którym ma zostać dokonane sprawdzenie.
     * @param subject na którym teraz student przebywa.
     */
    @Override
    public void apply(Student student, Subject subject)
    {
        System.out.println(description);
        float markToAdd = 2f;
        int statDifference = student.getStatistic(typeOfStatistic) - requiredStatistic;
        if (statDifference >= 0)
        {
            markToAdd = 3f;
            if (statDifference >= requiredStatistic)
                markToAdd = 5f;
            else if ((float) statDifference >= (float) requiredStatistic * .5f)
                markToAdd = 4f;

            System.out.print("Udało się, ");
        } else
            System.out.print("Nie udało się, ");

        System.out.println("otrzymałeś ocenę " + markToAdd);
        student.getNotes().add(subject, markToAdd);
    }
}
