package simulation.plan;

import simulation.subject.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomPlanGenerator {
    private final List<Subject> availableSubjects;

    public RandomPlanGenerator(List<Subject> availableSubjects) {
        this.availableSubjects = availableSubjects;
    }


    public Plan generate() {
        // generation logic

        Map<Day, List<Subject>> subjectsByDay = new HashMap<>();
        return new Plan(subjectsByDay);
    }
}
