package simulation.plan;

import simulation.subject.Subject;

import java.util.*;

/**
 * Klasa generująca losowy plan zajęć dla studenta, na podstawie listy dostępnych przedmiotów
 */
public class RandomPlanGenerator
{
    private final List<Subject> availableSubjects;

    /**
     * Konstruktor klasy
     *
     * @param availableSubjects Lista dostępnych przedmiotów, z której będziemy losować
     */
    public RandomPlanGenerator(List<Subject> availableSubjects) {
        this.availableSubjects = availableSubjects;
    }

    /**
     * Metoda generująca losowo plan dla studenta
     *
     * @return Wygenerowany plan
     */
    private Plan generateInternal(long seed)
    {
        Map<Day, List<Subject>> subjectsByDay = new HashMap<>();
        Random rand = new Random(seed);
        for (Day currentDay : Day.values())
        {
            int index = rand.nextInt(availableSubjects.size());
            List<Subject> subjects = Arrays.asList(availableSubjects.get(index));
            subjectsByDay.put(currentDay, subjects);
            availableSubjects.remove(index);

            if (availableSubjects.size() <= 0)
                break;
        }

        return new Plan(subjectsByDay);
    }

    public Plan generate() {
        return generateInternal(System.currentTimeMillis());
    }

    public Plan generate(long seed) {
        return generateInternal(seed);
    }
}
