import java.util.LinkedList;
import java.util.Map;

/**
 * klasa Student reprezentująca studenta
 * Student może uczestniczyć w różnych kursach
 * Student posiada statystki, na podstawie których sprawdzana jest wiedza podczas wydarzeń z przedmiotów oraz jego zachowania poza uczelnią.
 *
 */
public class Student
{
    /**
     * Przechowywane typy statystyk
     * */
    private Map<StatisticType, Integer> statistics;
    /**
     * Przechowywane bonusy do statystyk
     */
    private LinkedList<StatisticChange> statisticChanges = new LinkedList<>();

    /**
     * Tworzy nowego Studenta, wraz z losowo wygenerowanymi statystykami.
     *
     */
    public Student(IStudentStatGenerator generator)
    {
        statistics = generator.generateStats();
    }
    /**
     * Zwraca jedną z zadanych statystyk studenta.
     * @return typ statystyki studenta
     */
    public int getStatistic(StatisticType statisticType)
    {
        int returnAmount = statistics.getOrDefault(statisticType, 0);
        for (StatisticChange change : statisticChanges)
            returnAmount += change.getStatisticChange(statisticType);

        return returnAmount;
    }
    /**
     * Metoda usuwająca tymczasowy boost do statystyk
     */
    public void removeExpiredStatisticChanges()
    {
        statisticChanges.removeIf(StatisticChange::shouldRemove);
    }

    /**
     * Dodaje bonus do statystyki
     * @param statisticChange zmiana statystyki
     */
    public void addStatisticChange(StatisticChange statisticChange)
    {
        statisticChanges.add(statisticChange);
    }
    /**
     * Wydrukowanie statystyk w konsoli
     * @return statystyki w postaci napisu
     */
    public String printStats()
    {
        StringBuilder returnValue = new StringBuilder();
        for (Map.Entry<StatisticType, Integer> stat : statistics.entrySet())
        {
            returnValue.append(stat.getKey());
            returnValue.append(": ");
            returnValue.append(getStatistic(stat.getKey()));
            returnValue.append("\n");
        }
        return returnValue.toString();
    }
}