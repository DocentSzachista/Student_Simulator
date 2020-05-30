package simulation.plan;

import simulation.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Klasa trzymająca informacje o planie zajęć studenta
 */
public class Plan
{
    private final Map<Day, List<Subject>> subjectsByDay;

    /**
     * Konstruktor klasy
     * @param subjectsByDay Mapa dzień tygodnia, lista przedmiotów w tym dniu
     */
    public Plan(Map<Day, List<Subject>> subjectsByDay)
    {
        this.subjectsByDay = subjectsByDay;
    }

    /**
     * Metoda zwracjąca listę przedmiotów w danym dniu
     * @param day Dzień dla którego chcemy uzyskać listę przedmiotów
     * @return Lista przedmiotów w danym dniu
     */
    public List<Subject> getSubjectsFor(Day day)
    {
        return subjectsByDay.getOrDefault(day, new ArrayList<>());
    }

}
