import java.util.LinkedList;
import java.util.Map;

/**
 * klasa Student reprezentujaca studenta
 * Student moze uczestniczyc w roznych kursach
 * Student posiada statystki, na podstawie ktorych sprawdzana jest wiedza podczas wydarzen z
 * przedmiotow oraz jego zachowania poza uczelnią.
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
     * Tworzy instancje studenta, wraz z losowo wygenerowanymi statystykami.
     * @param generator generator statystyk
     */
    public Student(IStudentStatGenerator generator)
    {
        statistics = generator.generateStats();
    }
    /**
     * Zwraca jedna z zadanych statystyk studenta.
     * @param statisticType typ zadanej statystyki
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
     * Metoda usuwajaca tymczasowy boost do statystyk
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
    @Override
    public String toString()
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