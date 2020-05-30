package simulation.plan;

import simulation.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Plan {
    private final Map<Day, List<Subject>> subjectsByDay;

    public Plan(Map<Day, List<Subject>> subjectsByDay)
    {
        this.subjectsByDay = subjectsByDay;
    }

    public List<Subject> getSubjectsFor(Day day)
    {
        return subjectsByDay.getOrDefault(day, new ArrayList<>());
    }

}
