package simulation.plan;

import simulation.subject.Subject;

import java.util.*;

public class RandomPlanGenerator
{
    private final List<Subject> availableSubjects;

    public RandomPlanGenerator(List<Subject> availableSubjects)
    {
        this.availableSubjects = availableSubjects;
    }

    public Plan generate()
    {
        Map<Day, List<Subject>> subjectsByDay = new HashMap<>();
        Random rand = new Random();
        int subjectCount = availableSubjects.size();
        for(Day currentDay : Day.values())
        {
            int index = rand.nextInt(availableSubjects.size());
            List<Subject> subjects = Arrays.asList(availableSubjects.get(index));
            subjectsByDay.put(currentDay, subjects);
            availableSubjects.remove(index);

            if(availableSubjects.size() <= 0)
                break;
        }

        return new Plan(subjectsByDay);
    }
}
