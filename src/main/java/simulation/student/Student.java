package simulation.student;

import simulation.plan.Plan;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * klasa simulation.student.Student reprezentujaca studenta
 * simulation.student.Student moze uczestniczyc w roznych kursach
 * simulation.student.Student posiada statystki, na podstawie ktorych sprawdzana jest wiedza podczas wydarzen z
 * przedmiotow oraz jego zachowania poza uczelnią.
 */
public class Student {
    private final Map<StatisticType, Integer> statistics;

    private final Plan plan;

    private final List<StatisticChange> statisticChanges = new LinkedList<>();

    private final Notes notes = new Notes();

    public Student(Map<StatisticType, Integer> statistics, Plan plan)
    {
        this.statistics = statistics;
        this.plan = plan;
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
     *
     * @param statisticChange zmiana statystyki
     */
    public void addStatisticChange(StatisticChange statisticChange)
    {
        statisticChanges.add(statisticChange);
    }

    public Notes getNotes()
    {
        return notes;
    }

    public Plan getPlan()
    {
        return plan;
    }

    /**
     * Wydrukowanie statystyk w konsoli
     *
     * @return statystyki w postaci napisu
     */
    @Override
    public String toString()
    {
        StringBuilder returnValue = new StringBuilder();
        for (Map.Entry<StatisticType, Integer> stat : statistics.entrySet()) {
            returnValue.append(stat.getKey());
            returnValue.append(": ");
            returnValue.append(getStatistic(stat.getKey()));
            returnValue.append("\n");
        }
        return returnValue.toString();
    }
}
